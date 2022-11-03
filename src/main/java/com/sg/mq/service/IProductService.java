package com.sg.mq.service;

import com.sg.mq.domain.model.PageResult;
import com.sg.mq.domain.param.ProductParam;
import com.sg.mq.domain.query.ProductQuery;
import com.sg.mq.domain.vo.ProductVo;

public interface IProductService {

    boolean insert(ProductParam model);

    boolean update(ProductParam model);

    boolean deleteById(String id);

    PageResult<ProductVo> queryList(ProductQuery q);

    ProductVo getById(String id);
}
