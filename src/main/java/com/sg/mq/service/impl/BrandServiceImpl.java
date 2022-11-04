package com.sg.mq.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sg.mq.domain.entity.MdBrand;
import com.sg.mq.domain.mapper.MdBrandDynamicSqlSupport;
import com.sg.mq.domain.mapper.MdBrandMapper;
import com.sg.mq.domain.model.PageResult;
import com.sg.mq.domain.param.BrandParam;
import com.sg.mq.domain.query.BrandQuery;
import com.sg.mq.domain.vo.BrandVo;
import com.sg.mq.service.IBrandService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.sg.mq.domain.mapper.MdBrandDynamicSqlSupport.mdBrand;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Slf4j
@Service
public class BrandServiceImpl extends BaseService implements IBrandService {

    @Autowired
    MdBrandMapper mapper;

    @Override
    public boolean insert(BrandParam model) {
        MdBrand entity = new MdBrand();
        BeanUtils.copyProperties(model, entity);
        return super.retBool(mapper.insertSelective(entity));
    }

    @Override
    public boolean update(BrandParam model) {
        MdBrand entity = new MdBrand();
        BeanUtils.copyProperties(model, entity);
        return super.retBool(mapper.updateByPrimaryKeySelective(entity));
    }

    @Override
    public boolean deleteById(String id_) {
        return super.retBool(mapper.update(c -> c
                .set(MdBrandDynamicSqlSupport.isDel).equalTo(1)
                .set(MdBrandDynamicSqlSupport.updateUser).equalTo(getUserName())
                .set(MdBrandDynamicSqlSupport.updateTime).equalTo(LocalDateTime.now())
                .where(MdBrandDynamicSqlSupport.id,isEqualTo(id_))));
    }

    @Override
    public PageResult<BrandVo> queryList(BrandQuery q) {
        PageHelper.startPage(q.getPage(), q.getPageSize());
        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder builder = select(mapper.selectList)
                .from(mdBrand).where()
                .and(mdBrand.brandName,isLikeWhenPresent(q.getBrandName()).map(this::like));
        SelectStatementProvider selectStatement = builder.build().render(RenderingStrategies.MYBATIS3);
        List<MdBrand> list = mapper.selectMany(selectStatement);
        PageInfo<MdBrand> pageInfo=new PageInfo<>(list);
        List<BrandVo> vo = new ArrayList<>();
        list.forEach(f -> {
            BrandVo entity = new BrandVo();
            BeanUtils.copyProperties(f, entity);
            vo.add(entity);
        });
        return new PageResult(pageInfo.getTotal(),vo);
    }

    @Override
    public BrandVo getById(String id) {
        Optional<MdBrand> entity = mapper.selectByPrimaryKey(id);
        if(!entity.isPresent())
            return null;
        BrandVo vo = new BrandVo();
        BeanUtils.copyProperties(entity.get(), vo);
        return vo;
    }

}
