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
//const BASE_URL = 'http://192.168.1.30:8080';
const BASE_URL = 'http://his-regist:8080';
const CHANNEL = 'online';

function getToday() {
    const now = new Date();
    return `${now.getFullYear()}-${String(now.getMonth() + 1).padStart(2, '0')}-${String(now.getDate()).padStart(2, '0')}`;
}

//const CLINIC_DATE = '2025-12-16';
const CLINIC_DATE = getToday();
const DEPT_IDS = ['YJ028080', 'BQ009033'];

/* =========================
   3️⃣ ✅ 正确的号源预加载（setup阶段）
========================= */
export function setup() {
    let stockIds = [];

    console.log(`📅 当前挂号日期：${CLINIC_DATE}`);
    console.log(`🏥 参与抢号科室：${DEPT_IDS.join(',')}`);

    for (let deptId of DEPT_IDS) {
        let payload = JSON.stringify({
            channel: CHANNEL,
            deptId: deptId,
            clinicDate: CLINIC_DATE,
        });

        let res = http.post(`${BASE_URL}/tfwk-regist/regist/list`, payload, {
            headers: { 'Content-Type': 'application/json' },
        });

        if (res.status !== 200) {
            console.error(`❌ 科室 ${deptId} 接口失败 HTTP=${res.status}`);
            continue;
        }

        let data = res.json('data');

        if (!data || data.length === 0) {
            console.warn(`⚠️ 科室 ${deptId} 在 ${CLINIC_DATE} 下无号源`);
            continue;
        }

        console.log(`✅ 科室 ${deptId} 号源数量：${data.length}`);
        stockIds.push(...data.map(s => s.stockId));
    }

    console.log(`🎯 最终参与抢号总数：${stockIds.length}`);
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
        /*console.error('❌ 无可抢号源，终止执行');*/
        return;
    }

    let stockId = stockIds[Math.floor(Math.random() * stockIds.length)];
    let orderId = generateOrderId();
    let patientId = generatePatientId();

    let registPayload = JSON.stringify({
        channel: CHANNEL,
        stockId: stockId,
        patientId: patientId,
        orderId: orderId,
        flag: 'REG'
    });

    let res = http.post(`${BASE_URL}/tfwk-regist/regist/regist`, registPayload, {
        headers: { 'Content-Type': 'application/json' },
    });

    let body = res.json();

    check(res, {
        '挂号HTTP 200': r => r.status === 200,
        '挂号成功': r => r.json('code') === 0,
    });

    if (body.code !== 0) {
        console.log(`❌ 抢号失败 | stock=${stockId} | msg=${body.message}`);
    }

    // 随机决定是否退号（比如20%概率）
    if (Math.random() < 0.2) {
        let refundRes = http.post(`${BASE_URL}/tfwk-regist/regist/refund/${orderId}/REG`, {}, {
            headers: { 'Content-Type': 'application/json' },
        });

        let refundBody = refundRes.json();

        check(refundRes, {
            '退号HTTP 200': r => r.status === 200,
            '退号成功': r => r.json('code') === 0,
        });

        if (refundBody.code !== 0) {
            console.log(`❌ 退号失败 | orderId=${orderId} | msg=${refundBody.message}`);
        } else {
            console.log(`✅ 退号成功 | orderId=${orderId}`);
        }
    }

    sleep(0.3);
}
