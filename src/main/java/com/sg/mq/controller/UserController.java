package com.sg.mq.controller;

import com.sg.mq.domain.entity.UserVo;
import com.sg.mq.domain.model.JResult;
import com.sg.mq.domain.model.PageResult;
import com.sg.mq.domain.param.UserParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "user", description = "用户管理")
@RestController
@RequestMapping("user")
public class UserController extends BaseController{

    @Operation(summary = "获取用户",description = "获取用户明细")
    @GetMapping(value = "get")
    public JResult<UserVo> getUserById(@RequestParam UserParam param) {

        return success(new UserVo());
    }

    @GetMapping(value = "page")
    public JResult<PageResult<UserVo>> queryList(UserParam q) {
        return success(new PageResult(0L,null));
    }

    @Operation(summary = "添加用户")
    @PostMapping(value = "add")
    public JResult<UserVo> addUser(@RequestBody @Validated UserParam param) {

        return success(new UserVo());
    }

    @Operation(summary = "删除用户")
    @DeleteMapping(value = "delete")
    public JResult deleteUser(Long id) {

        return success();
    }

}
