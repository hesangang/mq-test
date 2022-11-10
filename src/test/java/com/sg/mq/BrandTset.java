package com.sg.mq;

import com.alibaba.fastjson.JSON;
import com.sg.mq.controller.BrandController;
import com.sg.mq.domain.model.JResult;
import com.sg.mq.domain.model.PageResult;
import com.sg.mq.domain.param.BrandParam;
import com.sg.mq.domain.query.BrandQuery;
import com.sg.mq.domain.util.IDGeneratorUtils;
import com.sg.mq.domain.vo.BrandVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@DisplayName("品牌接口测试")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BrandTset {

    @Autowired
    private BrandController brandController;

    @ParameterizedTest
    @ValueSource(ints = { 1 })
    void addBrand(int argument) {
        BrandParam param = new BrandParam();
        param.setId(IDGeneratorUtils.getId());
        param.setBrandName("华为");
        param.setBrandImg("www.huawei.png");
        param.setUrl("www.huawei.com");
        param.setCreateUser("system");
        param.setCreateTime(LocalDateTime.now());
        param.setUpdateUser("system");
        param.setUpdateTime(LocalDateTime.now());
        JResult<BrandParam> BrandVoJResult = brandController.addBrand(param);
        log.info("品牌接口测试:addBrand返回:{}", JSON.toJSON(BrandVoJResult));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1 })
    void queryBrand(int argument) {
        BrandQuery param = new BrandQuery();
        param.setBrandName("可口可乐");
        param.setUpdateTimeMin(LocalDateTime.now().plusDays(-1));
        param.setUpdateTimeMax(LocalDateTime.now());
        JResult<PageResult<BrandVo>> pageResultJResult = brandController.queryList(param);
        log.info("品牌接口测试:queryBrand:{}", JSON.toJSON(pageResultJResult));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1 })
    void getBrand(int argument) {
        String id = "1";
        JResult<BrandVo> pageResultJResult = brandController.getBrandById(id);
        log.info("品牌接口测试:getBrand:{}", JSON.toJSON(pageResultJResult));
    }
}
