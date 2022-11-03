package com.sg.mq.domain.mapper;

import static com.sg.mq.domain.mapper.SysUserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.sg.mq.domain.entity.SysUser;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface SysUserMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<SysUser>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, userName, nickName, userType, email, phone, sex, avatar, password, status, isDel, createUser, createTime, updateUser, updateTime, remark, expirationDate);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SysUserResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_type", property="userType", jdbcType=JdbcType.INTEGER),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.INTEGER),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="expiration_date", property="expirationDate", jdbcType=JdbcType.DATE)
    })
    List<SysUser> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SysUserResult")
    Optional<SysUser> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, sysUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, sysUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(String id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(SysUser row) {
        return MyBatis3Utils.insert(this::insert, row, sysUser, c ->
            c.map(id).toProperty("id")
            .map(userName).toProperty("userName")
            .map(nickName).toProperty("nickName")
            .map(userType).toProperty("userType")
            .map(email).toProperty("email")
            .map(phone).toProperty("phone")
            .map(sex).toProperty("sex")
            .map(avatar).toProperty("avatar")
            .map(password).toProperty("password")
            .map(status).toProperty("status")
            .map(isDel).toProperty("isDel")
            .map(createUser).toProperty("createUser")
            .map(createTime).toProperty("createTime")
            .map(updateUser).toProperty("updateUser")
            .map(updateTime).toProperty("updateTime")
            .map(remark).toProperty("remark")
            .map(expirationDate).toProperty("expirationDate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<SysUser> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, sysUser, c ->
            c.map(id).toProperty("id")
            .map(userName).toProperty("userName")
            .map(nickName).toProperty("nickName")
            .map(userType).toProperty("userType")
            .map(email).toProperty("email")
            .map(phone).toProperty("phone")
            .map(sex).toProperty("sex")
            .map(avatar).toProperty("avatar")
            .map(password).toProperty("password")
            .map(status).toProperty("status")
            .map(isDel).toProperty("isDel")
            .map(createUser).toProperty("createUser")
            .map(createTime).toProperty("createTime")
            .map(updateUser).toProperty("updateUser")
            .map(updateTime).toProperty("updateTime")
            .map(remark).toProperty("remark")
            .map(expirationDate).toProperty("expirationDate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(SysUser row) {
        return MyBatis3Utils.insert(this::insert, row, sysUser, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(userName).toPropertyWhenPresent("userName", row::getUserName)
            .map(nickName).toPropertyWhenPresent("nickName", row::getNickName)
            .map(userType).toPropertyWhenPresent("userType", row::getUserType)
            .map(email).toPropertyWhenPresent("email", row::getEmail)
            .map(phone).toPropertyWhenPresent("phone", row::getPhone)
            .map(sex).toPropertyWhenPresent("sex", row::getSex)
            .map(avatar).toPropertyWhenPresent("avatar", row::getAvatar)
            .map(password).toPropertyWhenPresent("password", row::getPassword)
            .map(status).toPropertyWhenPresent("status", row::getStatus)
            .map(isDel).toPropertyWhenPresent("isDel", row::getIsDel)
            .map(createUser).toPropertyWhenPresent("createUser", row::getCreateUser)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(updateUser).toPropertyWhenPresent("updateUser", row::getUpdateUser)
            .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
            .map(remark).toPropertyWhenPresent("remark", row::getRemark)
            .map(expirationDate).toPropertyWhenPresent("expirationDate", row::getExpirationDate)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<SysUser> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, sysUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SysUser> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, sysUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SysUser> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, sysUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<SysUser> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, sysUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(SysUser row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(userName).equalTo(row::getUserName)
                .set(nickName).equalTo(row::getNickName)
                .set(userType).equalTo(row::getUserType)
                .set(email).equalTo(row::getEmail)
                .set(phone).equalTo(row::getPhone)
                .set(sex).equalTo(row::getSex)
                .set(avatar).equalTo(row::getAvatar)
                .set(password).equalTo(row::getPassword)
                .set(status).equalTo(row::getStatus)
                .set(isDel).equalTo(row::getIsDel)
                .set(createUser).equalTo(row::getCreateUser)
                .set(createTime).equalTo(row::getCreateTime)
                .set(updateUser).equalTo(row::getUpdateUser)
                .set(updateTime).equalTo(row::getUpdateTime)
                .set(remark).equalTo(row::getRemark)
                .set(expirationDate).equalTo(row::getExpirationDate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SysUser row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(userName).equalToWhenPresent(row::getUserName)
                .set(nickName).equalToWhenPresent(row::getNickName)
                .set(userType).equalToWhenPresent(row::getUserType)
                .set(email).equalToWhenPresent(row::getEmail)
                .set(phone).equalToWhenPresent(row::getPhone)
                .set(sex).equalToWhenPresent(row::getSex)
                .set(avatar).equalToWhenPresent(row::getAvatar)
                .set(password).equalToWhenPresent(row::getPassword)
                .set(status).equalToWhenPresent(row::getStatus)
                .set(isDel).equalToWhenPresent(row::getIsDel)
                .set(createUser).equalToWhenPresent(row::getCreateUser)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(updateUser).equalToWhenPresent(row::getUpdateUser)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime)
                .set(remark).equalToWhenPresent(row::getRemark)
                .set(expirationDate).equalToWhenPresent(row::getExpirationDate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(SysUser row) {
        return update(c ->
            c.set(userName).equalTo(row::getUserName)
            .set(nickName).equalTo(row::getNickName)
            .set(userType).equalTo(row::getUserType)
            .set(email).equalTo(row::getEmail)
            .set(phone).equalTo(row::getPhone)
            .set(sex).equalTo(row::getSex)
            .set(avatar).equalTo(row::getAvatar)
            .set(password).equalTo(row::getPassword)
            .set(status).equalTo(row::getStatus)
            .set(isDel).equalTo(row::getIsDel)
            .set(createUser).equalTo(row::getCreateUser)
            .set(createTime).equalTo(row::getCreateTime)
            .set(updateUser).equalTo(row::getUpdateUser)
            .set(updateTime).equalTo(row::getUpdateTime)
            .set(remark).equalTo(row::getRemark)
            .set(expirationDate).equalTo(row::getExpirationDate)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(SysUser row) {
        return update(c ->
            c.set(userName).equalToWhenPresent(row::getUserName)
            .set(nickName).equalToWhenPresent(row::getNickName)
            .set(userType).equalToWhenPresent(row::getUserType)
            .set(email).equalToWhenPresent(row::getEmail)
            .set(phone).equalToWhenPresent(row::getPhone)
            .set(sex).equalToWhenPresent(row::getSex)
            .set(avatar).equalToWhenPresent(row::getAvatar)
            .set(password).equalToWhenPresent(row::getPassword)
            .set(status).equalToWhenPresent(row::getStatus)
            .set(isDel).equalToWhenPresent(row::getIsDel)
            .set(createUser).equalToWhenPresent(row::getCreateUser)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(updateUser).equalToWhenPresent(row::getUpdateUser)
            .set(updateTime).equalToWhenPresent(row::getUpdateTime)
            .set(remark).equalToWhenPresent(row::getRemark)
            .set(expirationDate).equalToWhenPresent(row::getExpirationDate)
            .where(id, isEqualTo(row::getId))
        );
    }
}