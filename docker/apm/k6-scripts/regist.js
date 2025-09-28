import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
    stages: [
        { duration: '10s', target: 10 },  // 预热阶段：10个VU
        { duration: '20s', target: 50 },  // 升流阶段：提升到50个VU
        { duration: '30s', target: 50 },  // 高峰阶段：保持50个VU
        { duration: '10s', target: 10 },  // 降流阶段：回到10个VU
        { duration: '5s', target: 0 },    // 收尾阶段：逐步降为0
    ],
    thresholds: {
        // 可以定义性能指标，便于自动化判断压测结果
        http_req_failed: ['rate<0.01'],    // 失败率 < 1%
        http_req_duration: ['p(95)<500'],  // 95%请求耗时 < 500ms
    }
};

const BASE_URL = 'http://his-regist:8080';
//const BASE_URL = 'http://192.168.1.30:8080';
const CHANNEL = 'online';

let stockIds = ['45'];

// 生成随机患者ID
function generatePatientId() {
    let rand = Math.floor(1000 + Math.random() * 9000);
    return `P${rand}`;
}

// 生成唯一订单号
function generateOrderId() {
    let timestamp = Date.now();
    let rand = Math.floor(1000 + Math.random() * 9000);
    return `O${timestamp}${rand}`;
}

export default function () {
    // 只在第一次迭代加载号源
    if (__ITER === 0 && stockIds.length === 0) {
        let deptRes = http.post(`${BASE_URL}/tfwk-regist/regist/getClinicDeptClassTree`, null, {
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        });

        check(deptRes, { 'dept接口响应200': (r) => r.status === 200 });

        let deptData = deptRes.json('data') || [];
        function collectDeptIds(list, ids = []) {
            for (let item of list) {
                if (item.deptList && item.deptList.length > 0) {
                    ids.push(...item.deptList.map(d => d.deptId));
                }
            }
            return ids;
        }

        //let deptIds = collectDeptIds(deptData);
        let deptIds = ['BQ010080','BQ016031'];
        if (!deptIds.length) {
            console.error("没有可用科室，停止压测");
            return;
        }

        for (let deptId of deptIds) {
            let listPayload = JSON.stringify({
                channel: CHANNEL,
                deptId: deptId,
                clinicDate: "2025-09-17",
            });

            let listRes = http.post(`${BASE_URL}/tfwk-regist/regist/list`, listPayload, {
                headers: { 'Content-Type': 'application/json' },
            });

            if (listRes.status === 200) {
                let data = listRes.json('data');
                if (data && data.length) {
                    stockIds.push(...data.map(s => s.stockId));
                }
            }
        }

        console.log(`预加载号源完成，共 ${stockIds.length} 个`);
    }

    // 并发挂号请求
    if (stockIds.length > 0) {
        let stockId = stockIds[Math.floor(Math.random() * stockIds.length)];
        let registPayload = JSON.stringify({
            channel: CHANNEL,
            stockId: stockId,
            patientId: generatePatientId(),
            orderId: generateOrderId(),
            flag: "REG"
        });

        let registRes = http.post(`${BASE_URL}/tfwk-regist/regist/regist`, registPayload, {
            headers: { 'Content-Type': 'application/json' },
        });
        let registJson = registRes.json();
        console.log(`挂号结果: code=${registJson.code}, msg=${registJson.message}`);
        check(registRes, {
            'regist接口响应200': (r) => r.status === 200,
            'regist返回成功': (r) => r.json('code') === 0,
        });
    }

    sleep(1);
}
