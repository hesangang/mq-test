package com.sg.mq.service;

import com.sg.mq.domain.model.PageResult;
import com.sg.mq.domain.param.CategoryParam;
import com.sg.mq.domain.query.CategoryQuery;
import com.sg.mq.domain.vo.CategoryVo;

public interface ICategoryService {

    boolean insert(CategoryParam model);

    boolean update(CategoryParam model);

    boolean deleteById(String id);

    PageResult<CategoryVo> queryList(CategoryQuery q);

    CategoryVo getById(String id);
}
