package com.sg.mq;

import com.alibaba.fastjson.JSON;
import com.sg.mq.controller.ProductController;
import com.sg.mq.domain.model.JResult;
import com.sg.mq.domain.model.PageResult;
import com.sg.mq.domain.param.ProductParam;
import com.sg.mq.domain.query.ProductQuery;
import com.sg.mq.domain.util.IDGeneratorUtils;
import com.sg.mq.domain.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@DisplayName("商品接口测试")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductTset {

    @Autowired
    private ProductController productController;

    @ParameterizedTest
    @ValueSource(ints = { 1 })
    void addProduct(int argument) {
        ProductParam param = new ProductParam();
        param.setId(IDGeneratorUtils.getId());
        param.setProductName("Mac");
        param.setProductCode(IDGeneratorUtils.getStrId());
        param.setProductType("1");
        param.setCateId("1038140070894239744");
        param.setCateName("冰箱");
        param.setBrandCode("1038162196007223296");
        param.setBrandName("可口可乐");
        param.setSupplierCode("G001");
        param.setNameInitials("M");
        param.setMktPrice(BigDecimal.valueOf(1001));
        param.setPrice(BigDecimal.valueOf(199));
        param.setPriceUnit("元");
        param.setWeight(BigDecimal.valueOf(11.5));
        param.setStockAmount(8000);
        param.setSaleAmount(5000);
        param.setReviewCount(2001);
        param.setReviewValidCount(1200);
        param.setReviewAverage(BigDecimal.valueOf(4.9));
        param.setInsaleStatus(1);
        param.setAuditStatus(1);
        param.setSaleTime(LocalDateTime.now());


        param.setCreateUser("system");
        param.setCreateTime(LocalDateTime.now());
        param.setUpdateUser("system");
        param.setUpdateTime(LocalDateTime.now());
        JResult<ProductParam> ProductVoJResult = productController.addProduct(param);
        log.info("商品接口测试:addProduct返回:{}", JSON.toJSON(ProductVoJResult));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1 })
    void queryProduct(int argument) {
        ProductQuery param = new ProductQuery();
        param.setCateName("冰箱");
        param.setBrandName("可口可乐");
        param.setUpdateTimeMin(LocalDateTime.now().plusDays(-1));
        param.setUpdateTimeMax(LocalDateTime.now());
        JResult<PageResult<ProductVo>> pageResultJResult = productController.queryList(param);
        log.info("商品接口测试:queryProduct:{}", JSON.toJSON(pageResultJResult));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1 })
    void getProduct(int argument) {
        String id = "1";
        JResult<ProductVo> pageResultJResult = productController.getProductById(id);
        log.info("商品接口测试:getProduct:{}", JSON.toJSON(pageResultJResult));
    }
}
