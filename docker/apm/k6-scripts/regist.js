import http from 'k6/http';
import { check, sleep } from 'k6';

/* =========================
   1️⃣ 压测配置
========================= */
export const options = {
    stages: [
        { duration: '5s', target: 20 },
        { duration: '10s', target: 100 },
        { duration: '10s', target: 100 },
        { duration: '5s', target: 0 },
    ],
};

/* =========================
   2️⃣ 基础参数
========================= */
const BASE_URL = 'http://192.168.1.30:8080';
const CHANNEL = 'online';

function getToday() {
    const now = new Date();
    return `${now.getFullYear()}-${String(now.getMonth() + 1).padStart(2, '0')}-${String(now.getDate()).padStart(2, '0')}`;
}

const CLINIC_DATE = getToday();
const DEPT_IDS = ['YJ028080', 'ZL015000'];

/* =========================
   3️⃣ ✅ 正确的号源预加载（setup阶段）
========================= */
export function setup() {
    let stockIds = [];

    for (let deptId of DEPT_IDS) {
        let payload = JSON.stringify({
            channel: CHANNEL,
            deptId: deptId,
            clinicDate: CLINIC_DATE,
        });

        let res = http.post(`${BASE_URL}/tfwk-regist/regist/list`, payload, {
            headers: { 'Content-Type': 'application/json' },
        });

        if (res.status === 200) {
            let data = res.json('data');
            if (data && data.length > 0) {
                stockIds.push(...data.map(s => s.stockId));
            }
        }
    }

    console.log(`✅ 号源预加载完成：${stockIds.length} 个`);
    return { stockIds };
}

/* =========================
   4️⃣ 用户 & 订单生成
========================= */
function generatePatientId() {
    return 'P' + (__VU * 100000 + __ITER);
}

function generateOrderId() {
    return 'O' + Date.now() + __VU + __ITER;
}

/* =========================
   5️⃣ ✅ 并发抢号主逻辑
========================= */
export default function (data) {
    const stockIds = data.stockIds;

    if (!stockIds || stockIds.length === 0) {
        console.error('❌ 无可抢号源，终止执行');
        return;
    }

    let stockId = stockIds[Math.floor(Math.random() * stockIds.length)];

    let registPayload = JSON.stringify({
        channel: CHANNEL,
        stockId: stockId,
        patientId: generatePatientId(),
        orderId: generateOrderId(),
        flag: 'REG'
    });

    let res = http.post(`${BASE_URL}/tfwk-regist/regist/regist`, registPayload, {
        headers: { 'Content-Type': 'application/json' },
    });

    let body = res.json();

    check(res, {
        'HTTP 200': r => r.status === 200,
        '业务成功': r => r.json('code') === 0,
    });

    if (body.code !== 0) {
        console.log(`❌ 抢号失败 | stock=${stockId} | msg=${body.message}`);
    }

    sleep(0.3);
}
