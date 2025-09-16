import http from 'k6/http';
import { check, sleep } from 'k6';

// 压测配置：50虚拟用户，持续60秒
export const options = {
    vus: 50,
    duration: '60s',
};

//const BASE_URL = 'http://192.168.1.30:8080';
const BASE_URL = 'http://his-regist:8080';
const CHANNEL = '114YY';

export default function () {
    // 1. 查询科室列表
    let deptRes = http.post(`${BASE_URL}/tfwk-regist/regist/getClinicDeptClassTree`, null, {
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
    });

    check(deptRes, {
        'dept接口响应200': (r) => r.status === 200,
    });

    let deptData = deptRes.json('data');
    if (!deptData || deptData.length === 0) {
        console.warn('未获取到科室，跳过后续流程');
        sleep(1);
        return;
    }

    // 递归提取所有 deptId（科室ID）
    function collectDeptIds(list, ids = []) {
        for (let item of list) {
            if (item.deptList && item.deptList.length > 0) {
                ids.push(...item.deptList.map(d => d.deptId));
            }
        }
        return ids;
    }
    let deptIds = collectDeptIds(deptData);

    if (!deptIds || deptIds.length === 0) {
        console.warn('未找到可用deptId，跳过后续流程');
        sleep(1);
        return;
    }

    // 遍历所有科室
    for (let deptId of deptIds) {
        // 2. 查询出诊号源列表
        let listPayload = JSON.stringify({
            channel: CHANNEL,
            deptId: deptId,
            clinicDate: "", // TODO: 替换为真实日期
        });

        let listRes = http.post(`${BASE_URL}/tfwk-regist/regist/list`, listPayload, {
            headers: { 'Content-Type': 'application/json' },
        });

        check(listRes, {
            'list接口响应200': (r) => r.status === 200,
        });

        let stockList = listRes.json('data');
        if (!stockList || stockList.length === 0) {
            console.warn(`科室 ${deptId} 未获取到号源`);
            continue;
        }

        // 遍历所有号源
        for (let stock of stockList) {
            let stockId = stock.stockId;

            // 3. 获取号源详情
            let getRes = http.post(`${BASE_URL}/tfwk-regist/regist/getStock/${stockId}/${CHANNEL}`, null, {
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
            });

            check(getRes, {
                'getStock接口响应200': (r) => r.status === 200,
            });

            // 生成唯一订单号：O + 时间戳 + 4位随机数
            function generateOrderId() {
                let timestamp = Date.now(); // 毫秒级时间戳
                let rand = Math.floor(1000 + Math.random() * 9000); // 1000~9999 四位随机数
                return `O${timestamp}${rand}`;
            }
            // 4. 模拟挂号
            let registPayload = JSON.stringify({
                channel: CHANNEL,
                stockId: stockId,
                patientId: "P123456",  // TODO: 替换成测试患者ID
                orderId: generateOrderId(),   // ✅ 使用随机订单号
                flag: "REG"
            });

            let registRes = http.post(`${BASE_URL}/tfwk-regist/regist/regist`, registPayload, {
                headers: { 'Content-Type': 'application/json' },
            });

            check(registRes, {
                'regist接口响应200': (r) => r.status === 200,
                'regist返回成功': (r) => r.json('code') === 0,
            });
        }
    }

    sleep(1);
}
