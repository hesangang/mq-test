package com.sg.mq.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sg.mq.domain.entity.SysUser;
import com.sg.mq.domain.mapper.SysUserDynamicSqlSupport;
import com.sg.mq.domain.mapper.SysUserMapper;
import com.sg.mq.domain.model.PageResult;
import com.sg.mq.domain.param.UserParam;
import com.sg.mq.domain.query.UserQuery;
import com.sg.mq.domain.vo.UserVo;
import com.sg.mq.service.IUserService;
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

import static com.sg.mq.domain.mapper.SysUserDynamicSqlSupport.sysUser;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Slf4j
@Service
public class UserServiceImpl extends BaseService implements IUserService {

    @Autowired
    SysUserMapper mapper;

    @Override
    public boolean insert(UserParam model) {
        SysUser entity = new SysUser();
        BeanUtils.copyProperties(model, entity);
        return super.retBool(mapper.insertSelective(entity));
    }

    @Override
    public boolean update(UserParam model) {
        SysUser entity = new SysUser();
        BeanUtils.copyProperties(model, entity);
        return super.retBool(mapper.updateByPrimaryKeySelective(entity));
    }

    @Override
    public boolean deleteById(String id_) {
        return super.retBool(mapper.update(c -> c
                .set(SysUserDynamicSqlSupport.isDel).equalTo(1)
                .set(SysUserDynamicSqlSupport.updateUser).equalTo(getUserName())
                .set(SysUserDynamicSqlSupport.updateTime).equalTo(LocalDateTime.now())
                .where(SysUserDynamicSqlSupport.id,isEqualTo(id_))));
    }

    @Override
    public PageResult<UserVo> queryList(UserQuery q) {
        PageHelper.startPage(q.getPage(), q.getPageSize());
        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder builder = select(mapper.selectList)
                .from(sysUser).where()
                .and(sysUser.userName,isLikeWhenPresent(q.getUserName()).map(this::like))
                .and(sysUser.phone,isLikeWhenPresent(q.getPhone()).map(this::like));;
        SelectStatementProvider selectStatement = builder.build().render(RenderingStrategies.MYBATIS3);
        List<SysUser> list = mapper.selectMany(selectStatement);
        PageInfo<SysUser> pageInfo=new PageInfo<>(list);
        List<UserVo> vo = new ArrayList<>();
        list.forEach(f -> {
            UserVo entity = new UserVo();
            BeanUtils.copyProperties(f, entity);
            vo.add(entity);
        });
        return new PageResult(pageInfo.getTotal(),vo);
    }

    @Override
    public UserVo getById(String id) {
        Optional<SysUser> entity = mapper.selectByPrimaryKey(id);
        if(!entity.isPresent())
            return null;
        UserVo vo = new UserVo();
        BeanUtils.copyProperties(entity.get(), vo);
        return vo;
    }

}
