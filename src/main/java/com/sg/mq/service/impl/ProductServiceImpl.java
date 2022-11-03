package com.sg.mq.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sg.mq.domain.entity.MdProduct;
import com.sg.mq.domain.mapper.MdProductDynamicSqlSupport;
import com.sg.mq.domain.mapper.MdProductMapper;
import com.sg.mq.domain.model.PageResult;
import com.sg.mq.domain.param.ProductParam;
import com.sg.mq.domain.query.ProductQuery;
import com.sg.mq.domain.vo.ProductVo;
import com.sg.mq.service.IProductService;
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

import static com.sg.mq.domain.mapper.MdProductDynamicSqlSupport.mdProduct;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Slf4j
@Service
public class ProductServiceImpl extends BaseService implements IProductService {

    @Autowired
    MdProductMapper mapper;

    @Override
    public boolean insert(ProductParam model) {
        MdProduct entity = new MdProduct();
        BeanUtils.copyProperties(model, entity);
        return super.retBool(mapper.insertSelective(entity));
    }

    @Override
    public boolean update(ProductParam model) {
        MdProduct entity = new MdProduct();
        BeanUtils.copyProperties(model, entity);
        return super.retBool(mapper.updateByPrimaryKeySelective(entity));
    }

    @Override
    public boolean deleteById(String id_) {
        return super.retBool(mapper.update(c -> c
                .set(MdProductDynamicSqlSupport.isDel).equalTo(1)
                .set(MdProductDynamicSqlSupport.updateUser).equalTo(getUserName())
                .set(MdProductDynamicSqlSupport.updateTime).equalTo(LocalDateTime.now())
                .where(MdProductDynamicSqlSupport.id,isEqualTo(id_))));
    }

    @Override
    public PageResult<ProductVo> queryList(ProductQuery q) {
        PageHelper.startPage(q.getPage(), q.getPageSize());
        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder builder = select(mapper.selectList)
                .from(mdProduct).where()
                .and(mdProduct.productName,isLikeWhenPresent(q.getProductName()).map(this::like));
        SelectStatementProvider selectStatement = builder.build().render(RenderingStrategies.MYBATIS3);
        List<MdProduct> list = mapper.selectMany(selectStatement);
        PageInfo<MdProduct> pageInfo=new PageInfo<>(list);
        List<ProductVo> vo = new ArrayList<>();
        list.forEach(f -> {
            ProductVo entity = new ProductVo();
            BeanUtils.copyProperties(f, entity);
            vo.add(entity);
        });
        return new PageResult(pageInfo.getTotal(),vo);
    }

    @Override
    public ProductVo getById(String id) {
        Optional<MdProduct> entity = mapper.selectByPrimaryKey(id);
        if(!entity.isPresent())
            return null;
        ProductVo vo = new ProductVo();
        BeanUtils.copyProperties(entity.get(), vo);
        return vo;
    }

}
