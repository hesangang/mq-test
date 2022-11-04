package com.sg.mq.service;

import com.sg.mq.domain.model.PageResult;
import com.sg.mq.domain.param.BrandParam;
import com.sg.mq.domain.query.BrandQuery;
import com.sg.mq.domain.vo.BrandVo;

public interface IBrandService {

    boolean insert(BrandParam model);

    boolean update(BrandParam model);

    boolean deleteById(String id);

    PageResult<BrandVo> queryList(BrandQuery q);

    BrandVo getById(String id);
}
