package com.sg.mq.domain.mapper;

import static com.sg.mq.domain.mapper.MdCategoryDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.sg.mq.domain.entity.MdCategory;
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
public interface MdCategoryMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<MdCategory>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, parentId, categoryName, categoryCode, categoryType, status, sort, updateUser, updateTime, createUser, createTime, isDel);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="MdCategoryResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="category_name", property="categoryName", jdbcType=JdbcType.VARCHAR),
        @Result(column="category_code", property="categoryCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="category_type", property="categoryType", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.INTEGER)
    })
    List<MdCategory> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("MdCategoryResult")
    Optional<MdCategory> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, mdCategory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, mdCategory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(String id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(MdCategory row) {
        return MyBatis3Utils.insert(this::insert, row, mdCategory, c ->
            c.map(id).toProperty("id")
            .map(parentId).toProperty("parentId")
            .map(categoryName).toProperty("categoryName")
            .map(categoryCode).toProperty("categoryCode")
            .map(categoryType).toProperty("categoryType")
            .map(status).toProperty("status")
            .map(sort).toProperty("sort")
            .map(updateUser).toProperty("updateUser")
            .map(updateTime).toProperty("updateTime")
            .map(createUser).toProperty("createUser")
            .map(createTime).toProperty("createTime")
            .map(isDel).toProperty("isDel")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<MdCategory> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, mdCategory, c ->
            c.map(id).toProperty("id")
            .map(parentId).toProperty("parentId")
            .map(categoryName).toProperty("categoryName")
            .map(categoryCode).toProperty("categoryCode")
            .map(categoryType).toProperty("categoryType")
            .map(status).toProperty("status")
            .map(sort).toProperty("sort")
            .map(updateUser).toProperty("updateUser")
            .map(updateTime).toProperty("updateTime")
            .map(createUser).toProperty("createUser")
            .map(createTime).toProperty("createTime")
            .map(isDel).toProperty("isDel")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(MdCategory row) {
        return MyBatis3Utils.insert(this::insert, row, mdCategory, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(parentId).toPropertyWhenPresent("parentId", row::getParentId)
            .map(categoryName).toPropertyWhenPresent("categoryName", row::getCategoryName)
            .map(categoryCode).toPropertyWhenPresent("categoryCode", row::getCategoryCode)
            .map(categoryType).toPropertyWhenPresent("categoryType", row::getCategoryType)
            .map(status).toPropertyWhenPresent("status", row::getStatus)
            .map(sort).toPropertyWhenPresent("sort", row::getSort)
            .map(updateUser).toPropertyWhenPresent("updateUser", row::getUpdateUser)
            .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
            .map(createUser).toPropertyWhenPresent("createUser", row::getCreateUser)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(isDel).toPropertyWhenPresent("isDel", row::getIsDel)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<MdCategory> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, mdCategory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<MdCategory> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, mdCategory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<MdCategory> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, mdCategory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<MdCategory> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, mdCategory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(MdCategory row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(parentId).equalTo(row::getParentId)
                .set(categoryName).equalTo(row::getCategoryName)
                .set(categoryCode).equalTo(row::getCategoryCode)
                .set(categoryType).equalTo(row::getCategoryType)
                .set(status).equalTo(row::getStatus)
                .set(sort).equalTo(row::getSort)
                .set(updateUser).equalTo(row::getUpdateUser)
                .set(updateTime).equalTo(row::getUpdateTime)
                .set(createUser).equalTo(row::getCreateUser)
                .set(createTime).equalTo(row::getCreateTime)
                .set(isDel).equalTo(row::getIsDel);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(MdCategory row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(parentId).equalToWhenPresent(row::getParentId)
                .set(categoryName).equalToWhenPresent(row::getCategoryName)
                .set(categoryCode).equalToWhenPresent(row::getCategoryCode)
                .set(categoryType).equalToWhenPresent(row::getCategoryType)
                .set(status).equalToWhenPresent(row::getStatus)
                .set(sort).equalToWhenPresent(row::getSort)
                .set(updateUser).equalToWhenPresent(row::getUpdateUser)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime)
                .set(createUser).equalToWhenPresent(row::getCreateUser)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(isDel).equalToWhenPresent(row::getIsDel);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(MdCategory row) {
        return update(c ->
            c.set(parentId).equalTo(row::getParentId)
            .set(categoryName).equalTo(row::getCategoryName)
            .set(categoryCode).equalTo(row::getCategoryCode)
            .set(categoryType).equalTo(row::getCategoryType)
            .set(status).equalTo(row::getStatus)
            .set(sort).equalTo(row::getSort)
            .set(updateUser).equalTo(row::getUpdateUser)
            .set(updateTime).equalTo(row::getUpdateTime)
            .set(createUser).equalTo(row::getCreateUser)
            .set(createTime).equalTo(row::getCreateTime)
            .set(isDel).equalTo(row::getIsDel)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(MdCategory row) {
        return update(c ->
            c.set(parentId).equalToWhenPresent(row::getParentId)
            .set(categoryName).equalToWhenPresent(row::getCategoryName)
            .set(categoryCode).equalToWhenPresent(row::getCategoryCode)
            .set(categoryType).equalToWhenPresent(row::getCategoryType)
            .set(status).equalToWhenPresent(row::getStatus)
            .set(sort).equalToWhenPresent(row::getSort)
            .set(updateUser).equalToWhenPresent(row::getUpdateUser)
            .set(updateTime).equalToWhenPresent(row::getUpdateTime)
            .set(createUser).equalToWhenPresent(row::getCreateUser)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(isDel).equalToWhenPresent(row::getIsDel)
            .where(id, isEqualTo(row::getId))
        );
    }
}