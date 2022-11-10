package com.sg.mq;

import com.alibaba.fastjson.JSON;
import com.sg.mq.controller.CategoryController;
import com.sg.mq.domain.model.JResult;
import com.sg.mq.domain.model.PageResult;
import com.sg.mq.domain.param.CategoryParam;
import com.sg.mq.domain.query.CategoryQuery;
import com.sg.mq.domain.util.IDGeneratorUtils;
import com.sg.mq.domain.vo.CategoryVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

@Slf4j
@DisplayName("品牌接口测试")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CategoryTset {

    @Autowired
    private CategoryController categoryController;

    @ParameterizedTest
    @ValueSource(ints = { 1 })
    void addCategory(int argument) {
        CategoryParam param = new CategoryParam();
        param.setId(IDGeneratorUtils.getId());
        param.setCategoryName("电脑");
        param.setCategoryCode("B002");
        param.setCategoryType("1");
        param.setCreateUser("system");
        param.setCreateTime(LocalDateTime.now());
        param.setUpdateUser("system");
        param.setUpdateTime(LocalDateTime.now());
        JResult<CategoryParam> CategoryVoJResult = categoryController.addCategory(param);
        log.info("品牌接口测试:addCategory返回:{}", JSON.toJSON(CategoryVoJResult));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1 })
    void queryCategory(int argument) {
        CategoryQuery param = new CategoryQuery();
        //param.setCategoryName("sangang");
        //param.setNickName("山岗");
        param.setUpdateTimeMin(LocalDateTime.now().plusDays(-1));
        param.setUpdateTimeMax(LocalDateTime.now());
        JResult<PageResult<CategoryVo>> pageResultJResult = categoryController.queryList(param);
        log.info("品牌接口测试:queryCategory:{}", JSON.toJSON(pageResultJResult));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1 })
    void getCategory(int argument) {
        String id = "1";
        JResult<CategoryVo> pageResultJResult = categoryController.getCategoryById(id);
        log.info("品牌接口测试:getCategory:{}", JSON.toJSON(pageResultJResult));
    }
}
