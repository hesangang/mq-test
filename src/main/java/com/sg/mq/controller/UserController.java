package com.sg.mq.controller;

import com.sg.mq.domain.query.UserQuery;
import com.sg.mq.domain.vo.UserVo;
import com.sg.mq.domain.model.JResult;
import com.sg.mq.domain.model.PageResult;
import com.sg.mq.domain.param.UserParam;
import com.sg.mq.search.UserSearch;
import com.sg.mq.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "user", description = "用户管理")
@RestController
@RequestMapping("user")
public class UserController extends BaseController{

    @Autowired
    IUserService userService;

    @Autowired
    UserSearch userSearch;

    @Operation(summary = "获取用户",description = "获取用户明细")
    @GetMapping(value = "get")
    public JResult<UserVo> getUserById(@RequestParam String id) {
        UserVo user = userSearch.getById(id);
        return success(user);
    }

    @GetMapping(value = "page")
    public JResult<PageResult<UserVo>> queryList(UserQuery q) {
        PageResult<UserVo> result = userSearch.queryList(q);
        return success(result);
    }

    @Operation(summary = "添加用户")
    @PostMapping(value = "add")
    public JResult<UserParam> addUser(@RequestBody @Validated UserParam param) {
        final boolean insert = userService.insert(param);
        return success(param);
    }

    @Operation(summary = "删除用户")
    @DeleteMapping(value = "delete")
    public JResult deleteUser(String id) {
        final boolean b = userService.deleteById(id);
        return success();
    }

}
