package com.sg.mq.service;

import com.sg.mq.domain.model.PageResult;
import com.sg.mq.domain.param.UserParam;
import com.sg.mq.domain.query.UserQuery;
import com.sg.mq.domain.vo.UserVo;

public interface IUserService {

    boolean insert(UserParam model);

    boolean update(UserParam model);

    boolean deleteById(String id);

    PageResult<UserVo> queryList(UserQuery q);

    UserVo getById(String id);
}
