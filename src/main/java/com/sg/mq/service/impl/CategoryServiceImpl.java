package com.sg.mq.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sg.mq.domain.entity.MdCategory;
import com.sg.mq.domain.mapper.MdCategoryDynamicSqlSupport;
import com.sg.mq.domain.mapper.MdCategoryMapper;
import com.sg.mq.domain.model.PageResult;
import com.sg.mq.domain.param.CategoryParam;
import com.sg.mq.domain.query.CategoryQuery;
import com.sg.mq.domain.vo.CategoryVo;
import com.sg.mq.service.ICategoryService;
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

import static com.sg.mq.domain.mapper.MdCategoryDynamicSqlSupport.mdCategory;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Slf4j
@Service
public class CategoryServiceImpl extends BaseService implements ICategoryService {

    @Autowired
    MdCategoryMapper mapper;

    @Override
    public boolean insert(CategoryParam model) {
        MdCategory entity = new MdCategory();
        BeanUtils.copyProperties(model, entity);
        return super.retBool(mapper.insertSelective(entity));
    }

    @Override
    public boolean update(CategoryParam model) {
        MdCategory entity = new MdCategory();
        BeanUtils.copyProperties(model, entity);
        return super.retBool(mapper.updateByPrimaryKeySelective(entity));
    }

    @Override
    public boolean deleteById(String id_) {
        return super.retBool(mapper.update(c -> c
                .set(MdCategoryDynamicSqlSupport.isDel).equalTo(1)
                .set(MdCategoryDynamicSqlSupport.updateUser).equalTo(getUserName())
                .set(MdCategoryDynamicSqlSupport.updateTime).equalTo(LocalDateTime.now())
                .where(MdCategoryDynamicSqlSupport.id,isEqualTo(id_))));
    }

    @Override
    public PageResult<CategoryVo> queryList(CategoryQuery q) {
        PageHelper.startPage(q.getPage(), q.getPageSize());
        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder builder = select(mapper.selectList)
                .from(mdCategory).where()
                .and(mdCategory.categoryName,isLikeWhenPresent(q.getCategoryName()).map(this::like));
        SelectStatementProvider selectStatement = builder.build().render(RenderingStrategies.MYBATIS3);
        List<MdCategory> list = mapper.selectMany(selectStatement);
        PageInfo<MdCategory> pageInfo=new PageInfo<>(list);
        List<CategoryVo> vo = new ArrayList<>();
        list.forEach(f -> {
            CategoryVo entity = new CategoryVo();
            BeanUtils.copyProperties(f, entity);
            vo.add(entity);
        });
        return new PageResult(pageInfo.getTotal(),vo);
    }

    @Override
    public CategoryVo getById(String id) {
        Optional<MdCategory> entity = mapper.selectByPrimaryKey(id);
        if(!entity.isPresent())
            return null;
        CategoryVo vo = new CategoryVo();
        BeanUtils.copyProperties(entity.get(), vo);
        return vo;
    }

}
