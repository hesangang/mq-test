package com.sg.mq.domain.mapper;

import static com.sg.mq.domain.mapper.MdBrandDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.sg.mq.domain.entity.MdBrand;
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
public interface MdBrandMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<MdBrand>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, brandName, brandImg, url, description, sort, enable, resellerLevel, recommend, createUser, createTime, updateUser, updateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="MdBrandResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="brand_name", property="brandName", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand_img", property="brandImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="enable", property="enable", jdbcType=JdbcType.INTEGER),
        @Result(column="reseller_level", property="resellerLevel", jdbcType=JdbcType.VARCHAR),
        @Result(column="recommend", property="recommend", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<MdBrand> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("MdBrandResult")
    Optional<MdBrand> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, mdBrand, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, mdBrand, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(String id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(MdBrand row) {
        return MyBatis3Utils.insert(this::insert, row, mdBrand, c ->
            c.map(id).toProperty("id")
            .map(brandName).toProperty("brandName")
            .map(brandImg).toProperty("brandImg")
            .map(url).toProperty("url")
            .map(description).toProperty("description")
            .map(sort).toProperty("sort")
            .map(enable).toProperty("enable")
            .map(resellerLevel).toProperty("resellerLevel")
            .map(recommend).toProperty("recommend")
            .map(createUser).toProperty("createUser")
            .map(createTime).toProperty("createTime")
            .map(updateUser).toProperty("updateUser")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<MdBrand> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, mdBrand, c ->
            c.map(id).toProperty("id")
            .map(brandName).toProperty("brandName")
            .map(brandImg).toProperty("brandImg")
            .map(url).toProperty("url")
            .map(description).toProperty("description")
            .map(sort).toProperty("sort")
            .map(enable).toProperty("enable")
            .map(resellerLevel).toProperty("resellerLevel")
            .map(recommend).toProperty("recommend")
            .map(createUser).toProperty("createUser")
            .map(createTime).toProperty("createTime")
            .map(updateUser).toProperty("updateUser")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(MdBrand row) {
        return MyBatis3Utils.insert(this::insert, row, mdBrand, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(brandName).toPropertyWhenPresent("brandName", row::getBrandName)
            .map(brandImg).toPropertyWhenPresent("brandImg", row::getBrandImg)
            .map(url).toPropertyWhenPresent("url", row::getUrl)
            .map(description).toPropertyWhenPresent("description", row::getDescription)
            .map(sort).toPropertyWhenPresent("sort", row::getSort)
            .map(enable).toPropertyWhenPresent("enable", row::getEnable)
            .map(resellerLevel).toPropertyWhenPresent("resellerLevel", row::getResellerLevel)
            .map(recommend).toPropertyWhenPresent("recommend", row::getRecommend)
            .map(createUser).toPropertyWhenPresent("createUser", row::getCreateUser)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(updateUser).toPropertyWhenPresent("updateUser", row::getUpdateUser)
            .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<MdBrand> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, mdBrand, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<MdBrand> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, mdBrand, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<MdBrand> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, mdBrand, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<MdBrand> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, mdBrand, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(MdBrand row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(brandName).equalTo(row::getBrandName)
                .set(brandImg).equalTo(row::getBrandImg)
                .set(url).equalTo(row::getUrl)
                .set(description).equalTo(row::getDescription)
                .set(sort).equalTo(row::getSort)
                .set(enable).equalTo(row::getEnable)
                .set(resellerLevel).equalTo(row::getResellerLevel)
                .set(recommend).equalTo(row::getRecommend)
                .set(createUser).equalTo(row::getCreateUser)
                .set(createTime).equalTo(row::getCreateTime)
                .set(updateUser).equalTo(row::getUpdateUser)
                .set(updateTime).equalTo(row::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(MdBrand row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(brandName).equalToWhenPresent(row::getBrandName)
                .set(brandImg).equalToWhenPresent(row::getBrandImg)
                .set(url).equalToWhenPresent(row::getUrl)
                .set(description).equalToWhenPresent(row::getDescription)
                .set(sort).equalToWhenPresent(row::getSort)
                .set(enable).equalToWhenPresent(row::getEnable)
                .set(resellerLevel).equalToWhenPresent(row::getResellerLevel)
                .set(recommend).equalToWhenPresent(row::getRecommend)
                .set(createUser).equalToWhenPresent(row::getCreateUser)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(updateUser).equalToWhenPresent(row::getUpdateUser)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(MdBrand row) {
        return update(c ->
            c.set(brandName).equalTo(row::getBrandName)
            .set(brandImg).equalTo(row::getBrandImg)
            .set(url).equalTo(row::getUrl)
            .set(description).equalTo(row::getDescription)
            .set(sort).equalTo(row::getSort)
            .set(enable).equalTo(row::getEnable)
            .set(resellerLevel).equalTo(row::getResellerLevel)
            .set(recommend).equalTo(row::getRecommend)
            .set(createUser).equalTo(row::getCreateUser)
            .set(createTime).equalTo(row::getCreateTime)
            .set(updateUser).equalTo(row::getUpdateUser)
            .set(updateTime).equalTo(row::getUpdateTime)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(MdBrand row) {
        return update(c ->
            c.set(brandName).equalToWhenPresent(row::getBrandName)
            .set(brandImg).equalToWhenPresent(row::getBrandImg)
            .set(url).equalToWhenPresent(row::getUrl)
            .set(description).equalToWhenPresent(row::getDescription)
            .set(sort).equalToWhenPresent(row::getSort)
            .set(enable).equalToWhenPresent(row::getEnable)
            .set(resellerLevel).equalToWhenPresent(row::getResellerLevel)
            .set(recommend).equalToWhenPresent(row::getRecommend)
            .set(createUser).equalToWhenPresent(row::getCreateUser)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(updateUser).equalToWhenPresent(row::getUpdateUser)
            .set(updateTime).equalToWhenPresent(row::getUpdateTime)
            .where(id, isEqualTo(row::getId))
        );
    }
}