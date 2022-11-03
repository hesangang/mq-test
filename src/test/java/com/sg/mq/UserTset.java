package com.sg.mq;

import com.alibaba.fastjson.JSON;
import com.sg.mq.controller.UserController;
import com.sg.mq.domain.model.JResult;
import com.sg.mq.domain.model.PageResult;
import com.sg.mq.domain.param.UserParam;
import com.sg.mq.domain.query.UserQuery;
import com.sg.mq.domain.util.IDGeneratorUtils;
import com.sg.mq.domain.vo.UserVo;
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
@DisplayName("用户接口测试")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserTset {

    @Autowired
    private UserController userController;

    @ParameterizedTest
    @ValueSource(ints = { 1 })
    void addUser(int argument) {
        UserParam param = new UserParam();
        param.setId(IDGeneratorUtils.getId());
        param.setUserName("sangang");
        param.setNickName("山岗");
        param.setPassword("123");
        param.setPhone("18888888888");
        param.setEmail("123@qq.com");
        param.setSex(1);
        param.setExpirationDate(LocalDate.now());
        param.setCreateUser("system");
        param.setCreateTime(LocalDateTime.now());
        param.setUpdateUser("system");
        param.setUpdateTime(LocalDateTime.now());
        JResult<UserParam> userVoJResult = userController.addUser(param);
        log.info("用户接口测试:addUser返回:{}", JSON.toJSON(userVoJResult));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1 })
    void queryUser(int argument) {
        UserQuery param = new UserQuery();
        //param.setUserName("sangang");
        //param.setNickName("山岗");
        param.setPhone("18888888888");
        param.setUpdateTimeMin(LocalDateTime.now().plusDays(-1));
        param.setUpdateTimeMax(LocalDateTime.now());
        JResult<PageResult<UserVo>> pageResultJResult = userController.queryList(param);
        log.info("用户接口测试:queryUser:{}", JSON.toJSON(pageResultJResult));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1 })
    void getUser(int argument) {
        String id = "1";
        JResult<UserVo> pageResultJResult = userController.getUserById(id);
        log.info("用户接口测试:getUser:{}", JSON.toJSON(pageResultJResult));
    }
}
