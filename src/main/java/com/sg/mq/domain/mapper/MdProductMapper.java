package com.sg.mq.domain.mapper;

import static com.sg.mq.domain.mapper.MdProductDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.sg.mq.domain.entity.MdProduct;
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
public interface MdProductMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<MdProduct>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, productCode, cateId, cateName, brandCode, brandName, productType, supplierCode, productName, nameInitials, mktPrice, purchasingPrice, price, tempPrice, priceUnit, weight, img, stockAmount, saleAmount, reviewCount, reviewValidCount, reviewAverage, insaleStatus, favorStatus, auditStatus, saleTime, intro, alertAmount, usableAmount, noStock, maker, sort, quotaAmount, bissnessType, purchaserCode, unSaleTime, videoPath, videoBanner, createUser, createTime, updateUser, updateTime, isDel);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="MdProductResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="product_code", property="productCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="cate_id", property="cateId", jdbcType=JdbcType.VARCHAR),
        @Result(column="cate_name", property="cateName", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand_code", property="brandCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand_name", property="brandName", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_type", property="productType", jdbcType=JdbcType.VARCHAR),
        @Result(column="supplier_code", property="supplierCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
        @Result(column="name_initials", property="nameInitials", jdbcType=JdbcType.VARCHAR),
        @Result(column="mkt_price", property="mktPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="purchasing_price", property="purchasingPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="temp_price", property="tempPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="price_unit", property="priceUnit", jdbcType=JdbcType.VARCHAR),
        @Result(column="weight", property="weight", jdbcType=JdbcType.DECIMAL),
        @Result(column="img", property="img", jdbcType=JdbcType.VARCHAR),
        @Result(column="stock_amount", property="stockAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="sale_amount", property="saleAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="review_count", property="reviewCount", jdbcType=JdbcType.INTEGER),
        @Result(column="review_valid_count", property="reviewValidCount", jdbcType=JdbcType.INTEGER),
        @Result(column="review_average", property="reviewAverage", jdbcType=JdbcType.DECIMAL),
        @Result(column="insale_status", property="insaleStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="favor_status", property="favorStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="sale_time", property="saleTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="alert_amount", property="alertAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="usable_amount", property="usableAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="no_stock", property="noStock", jdbcType=JdbcType.INTEGER),
        @Result(column="maker", property="maker", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="quota_amount", property="quotaAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="bissness_type", property="bissnessType", jdbcType=JdbcType.INTEGER),
        @Result(column="purchaser_code", property="purchaserCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="un_sale_time", property="unSaleTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="video_path", property="videoPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="video_banner", property="videoBanner", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.INTEGER)
    })
    List<MdProduct> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("MdProductResult")
    Optional<MdProduct> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, mdProduct, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, mdProduct, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(String id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(MdProduct row) {
        return MyBatis3Utils.insert(this::insert, row, mdProduct, c ->
            c.map(id).toProperty("id")
            .map(productCode).toProperty("productCode")
            .map(cateId).toProperty("cateId")
            .map(cateName).toProperty("cateName")
            .map(brandCode).toProperty("brandCode")
            .map(brandName).toProperty("brandName")
            .map(productType).toProperty("productType")
            .map(supplierCode).toProperty("supplierCode")
            .map(productName).toProperty("productName")
            .map(nameInitials).toProperty("nameInitials")
            .map(mktPrice).toProperty("mktPrice")
            .map(purchasingPrice).toProperty("purchasingPrice")
            .map(price).toProperty("price")
            .map(tempPrice).toProperty("tempPrice")
            .map(priceUnit).toProperty("priceUnit")
            .map(weight).toProperty("weight")
            .map(img).toProperty("img")
            .map(stockAmount).toProperty("stockAmount")
            .map(saleAmount).toProperty("saleAmount")
            .map(reviewCount).toProperty("reviewCount")
            .map(reviewValidCount).toProperty("reviewValidCount")
            .map(reviewAverage).toProperty("reviewAverage")
            .map(insaleStatus).toProperty("insaleStatus")
            .map(favorStatus).toProperty("favorStatus")
            .map(auditStatus).toProperty("auditStatus")
            .map(saleTime).toProperty("saleTime")
            .map(intro).toProperty("intro")
            .map(alertAmount).toProperty("alertAmount")
            .map(usableAmount).toProperty("usableAmount")
            .map(noStock).toProperty("noStock")
            .map(maker).toProperty("maker")
            .map(sort).toProperty("sort")
            .map(quotaAmount).toProperty("quotaAmount")
            .map(bissnessType).toProperty("bissnessType")
            .map(purchaserCode).toProperty("purchaserCode")
            .map(unSaleTime).toProperty("unSaleTime")
            .map(videoPath).toProperty("videoPath")
            .map(videoBanner).toProperty("videoBanner")
            .map(createUser).toProperty("createUser")
            .map(createTime).toProperty("createTime")
            .map(updateUser).toProperty("updateUser")
            .map(updateTime).toProperty("updateTime")
            .map(isDel).toProperty("isDel")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<MdProduct> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, mdProduct, c ->
            c.map(id).toProperty("id")
            .map(productCode).toProperty("productCode")
            .map(cateId).toProperty("cateId")
            .map(cateName).toProperty("cateName")
            .map(brandCode).toProperty("brandCode")
            .map(brandName).toProperty("brandName")
            .map(productType).toProperty("productType")
            .map(supplierCode).toProperty("supplierCode")
            .map(productName).toProperty("productName")
            .map(nameInitials).toProperty("nameInitials")
            .map(mktPrice).toProperty("mktPrice")
            .map(purchasingPrice).toProperty("purchasingPrice")
            .map(price).toProperty("price")
            .map(tempPrice).toProperty("tempPrice")
            .map(priceUnit).toProperty("priceUnit")
            .map(weight).toProperty("weight")
            .map(img).toProperty("img")
            .map(stockAmount).toProperty("stockAmount")
            .map(saleAmount).toProperty("saleAmount")
            .map(reviewCount).toProperty("reviewCount")
            .map(reviewValidCount).toProperty("reviewValidCount")
            .map(reviewAverage).toProperty("reviewAverage")
            .map(insaleStatus).toProperty("insaleStatus")
            .map(favorStatus).toProperty("favorStatus")
            .map(auditStatus).toProperty("auditStatus")
            .map(saleTime).toProperty("saleTime")
            .map(intro).toProperty("intro")
            .map(alertAmount).toProperty("alertAmount")
            .map(usableAmount).toProperty("usableAmount")
            .map(noStock).toProperty("noStock")
            .map(maker).toProperty("maker")
            .map(sort).toProperty("sort")
            .map(quotaAmount).toProperty("quotaAmount")
            .map(bissnessType).toProperty("bissnessType")
            .map(purchaserCode).toProperty("purchaserCode")
            .map(unSaleTime).toProperty("unSaleTime")
            .map(videoPath).toProperty("videoPath")
            .map(videoBanner).toProperty("videoBanner")
            .map(createUser).toProperty("createUser")
            .map(createTime).toProperty("createTime")
            .map(updateUser).toProperty("updateUser")
            .map(updateTime).toProperty("updateTime")
            .map(isDel).toProperty("isDel")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(MdProduct row) {
        return MyBatis3Utils.insert(this::insert, row, mdProduct, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(productCode).toPropertyWhenPresent("productCode", row::getProductCode)
            .map(cateId).toPropertyWhenPresent("cateId", row::getCateId)
            .map(cateName).toPropertyWhenPresent("cateName", row::getCateName)
            .map(brandCode).toPropertyWhenPresent("brandCode", row::getBrandCode)
            .map(brandName).toPropertyWhenPresent("brandName", row::getBrandName)
            .map(productType).toPropertyWhenPresent("productType", row::getProductType)
            .map(supplierCode).toPropertyWhenPresent("supplierCode", row::getSupplierCode)
            .map(productName).toPropertyWhenPresent("productName", row::getProductName)
            .map(nameInitials).toPropertyWhenPresent("nameInitials", row::getNameInitials)
            .map(mktPrice).toPropertyWhenPresent("mktPrice", row::getMktPrice)
            .map(purchasingPrice).toPropertyWhenPresent("purchasingPrice", row::getPurchasingPrice)
            .map(price).toPropertyWhenPresent("price", row::getPrice)
            .map(tempPrice).toPropertyWhenPresent("tempPrice", row::getTempPrice)
            .map(priceUnit).toPropertyWhenPresent("priceUnit", row::getPriceUnit)
            .map(weight).toPropertyWhenPresent("weight", row::getWeight)
            .map(img).toPropertyWhenPresent("img", row::getImg)
            .map(stockAmount).toPropertyWhenPresent("stockAmount", row::getStockAmount)
            .map(saleAmount).toPropertyWhenPresent("saleAmount", row::getSaleAmount)
            .map(reviewCount).toPropertyWhenPresent("reviewCount", row::getReviewCount)
            .map(reviewValidCount).toPropertyWhenPresent("reviewValidCount", row::getReviewValidCount)
            .map(reviewAverage).toPropertyWhenPresent("reviewAverage", row::getReviewAverage)
            .map(insaleStatus).toPropertyWhenPresent("insaleStatus", row::getInsaleStatus)
            .map(favorStatus).toPropertyWhenPresent("favorStatus", row::getFavorStatus)
            .map(auditStatus).toPropertyWhenPresent("auditStatus", row::getAuditStatus)
            .map(saleTime).toPropertyWhenPresent("saleTime", row::getSaleTime)
            .map(intro).toPropertyWhenPresent("intro", row::getIntro)
            .map(alertAmount).toPropertyWhenPresent("alertAmount", row::getAlertAmount)
            .map(usableAmount).toPropertyWhenPresent("usableAmount", row::getUsableAmount)
            .map(noStock).toPropertyWhenPresent("noStock", row::getNoStock)
            .map(maker).toPropertyWhenPresent("maker", row::getMaker)
            .map(sort).toPropertyWhenPresent("sort", row::getSort)
            .map(quotaAmount).toPropertyWhenPresent("quotaAmount", row::getQuotaAmount)
            .map(bissnessType).toPropertyWhenPresent("bissnessType", row::getBissnessType)
            .map(purchaserCode).toPropertyWhenPresent("purchaserCode", row::getPurchaserCode)
            .map(unSaleTime).toPropertyWhenPresent("unSaleTime", row::getUnSaleTime)
            .map(videoPath).toPropertyWhenPresent("videoPath", row::getVideoPath)
            .map(videoBanner).toPropertyWhenPresent("videoBanner", row::getVideoBanner)
            .map(createUser).toPropertyWhenPresent("createUser", row::getCreateUser)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(updateUser).toPropertyWhenPresent("updateUser", row::getUpdateUser)
            .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
            .map(isDel).toPropertyWhenPresent("isDel", row::getIsDel)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<MdProduct> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, mdProduct, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<MdProduct> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, mdProduct, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<MdProduct> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, mdProduct, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<MdProduct> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, mdProduct, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(MdProduct row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(productCode).equalTo(row::getProductCode)
                .set(cateId).equalTo(row::getCateId)
                .set(cateName).equalTo(row::getCateName)
                .set(brandCode).equalTo(row::getBrandCode)
                .set(brandName).equalTo(row::getBrandName)
                .set(productType).equalTo(row::getProductType)
                .set(supplierCode).equalTo(row::getSupplierCode)
                .set(productName).equalTo(row::getProductName)
                .set(nameInitials).equalTo(row::getNameInitials)
                .set(mktPrice).equalTo(row::getMktPrice)
                .set(purchasingPrice).equalTo(row::getPurchasingPrice)
                .set(price).equalTo(row::getPrice)
                .set(tempPrice).equalTo(row::getTempPrice)
                .set(priceUnit).equalTo(row::getPriceUnit)
                .set(weight).equalTo(row::getWeight)
                .set(img).equalTo(row::getImg)
                .set(stockAmount).equalTo(row::getStockAmount)
                .set(saleAmount).equalTo(row::getSaleAmount)
                .set(reviewCount).equalTo(row::getReviewCount)
                .set(reviewValidCount).equalTo(row::getReviewValidCount)
                .set(reviewAverage).equalTo(row::getReviewAverage)
                .set(insaleStatus).equalTo(row::getInsaleStatus)
                .set(favorStatus).equalTo(row::getFavorStatus)
                .set(auditStatus).equalTo(row::getAuditStatus)
                .set(saleTime).equalTo(row::getSaleTime)
                .set(intro).equalTo(row::getIntro)
                .set(alertAmount).equalTo(row::getAlertAmount)
                .set(usableAmount).equalTo(row::getUsableAmount)
                .set(noStock).equalTo(row::getNoStock)
                .set(maker).equalTo(row::getMaker)
                .set(sort).equalTo(row::getSort)
                .set(quotaAmount).equalTo(row::getQuotaAmount)
                .set(bissnessType).equalTo(row::getBissnessType)
                .set(purchaserCode).equalTo(row::getPurchaserCode)
                .set(unSaleTime).equalTo(row::getUnSaleTime)
                .set(videoPath).equalTo(row::getVideoPath)
                .set(videoBanner).equalTo(row::getVideoBanner)
                .set(createUser).equalTo(row::getCreateUser)
                .set(createTime).equalTo(row::getCreateTime)
                .set(updateUser).equalTo(row::getUpdateUser)
                .set(updateTime).equalTo(row::getUpdateTime)
                .set(isDel).equalTo(row::getIsDel);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(MdProduct row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(productCode).equalToWhenPresent(row::getProductCode)
                .set(cateId).equalToWhenPresent(row::getCateId)
                .set(cateName).equalToWhenPresent(row::getCateName)
                .set(brandCode).equalToWhenPresent(row::getBrandCode)
                .set(brandName).equalToWhenPresent(row::getBrandName)
                .set(productType).equalToWhenPresent(row::getProductType)
                .set(supplierCode).equalToWhenPresent(row::getSupplierCode)
                .set(productName).equalToWhenPresent(row::getProductName)
                .set(nameInitials).equalToWhenPresent(row::getNameInitials)
                .set(mktPrice).equalToWhenPresent(row::getMktPrice)
                .set(purchasingPrice).equalToWhenPresent(row::getPurchasingPrice)
                .set(price).equalToWhenPresent(row::getPrice)
                .set(tempPrice).equalToWhenPresent(row::getTempPrice)
                .set(priceUnit).equalToWhenPresent(row::getPriceUnit)
                .set(weight).equalToWhenPresent(row::getWeight)
                .set(img).equalToWhenPresent(row::getImg)
                .set(stockAmount).equalToWhenPresent(row::getStockAmount)
                .set(saleAmount).equalToWhenPresent(row::getSaleAmount)
                .set(reviewCount).equalToWhenPresent(row::getReviewCount)
                .set(reviewValidCount).equalToWhenPresent(row::getReviewValidCount)
                .set(reviewAverage).equalToWhenPresent(row::getReviewAverage)
                .set(insaleStatus).equalToWhenPresent(row::getInsaleStatus)
                .set(favorStatus).equalToWhenPresent(row::getFavorStatus)
                .set(auditStatus).equalToWhenPresent(row::getAuditStatus)
                .set(saleTime).equalToWhenPresent(row::getSaleTime)
                .set(intro).equalToWhenPresent(row::getIntro)
                .set(alertAmount).equalToWhenPresent(row::getAlertAmount)
                .set(usableAmount).equalToWhenPresent(row::getUsableAmount)
                .set(noStock).equalToWhenPresent(row::getNoStock)
                .set(maker).equalToWhenPresent(row::getMaker)
                .set(sort).equalToWhenPresent(row::getSort)
                .set(quotaAmount).equalToWhenPresent(row::getQuotaAmount)
                .set(bissnessType).equalToWhenPresent(row::getBissnessType)
                .set(purchaserCode).equalToWhenPresent(row::getPurchaserCode)
                .set(unSaleTime).equalToWhenPresent(row::getUnSaleTime)
                .set(videoPath).equalToWhenPresent(row::getVideoPath)
                .set(videoBanner).equalToWhenPresent(row::getVideoBanner)
                .set(createUser).equalToWhenPresent(row::getCreateUser)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(updateUser).equalToWhenPresent(row::getUpdateUser)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime)
                .set(isDel).equalToWhenPresent(row::getIsDel);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(MdProduct row) {
        return update(c ->
            c.set(productCode).equalTo(row::getProductCode)
            .set(cateId).equalTo(row::getCateId)
            .set(cateName).equalTo(row::getCateName)
            .set(brandCode).equalTo(row::getBrandCode)
            .set(brandName).equalTo(row::getBrandName)
            .set(productType).equalTo(row::getProductType)
            .set(supplierCode).equalTo(row::getSupplierCode)
            .set(productName).equalTo(row::getProductName)
            .set(nameInitials).equalTo(row::getNameInitials)
            .set(mktPrice).equalTo(row::getMktPrice)
            .set(purchasingPrice).equalTo(row::getPurchasingPrice)
            .set(price).equalTo(row::getPrice)
            .set(tempPrice).equalTo(row::getTempPrice)
            .set(priceUnit).equalTo(row::getPriceUnit)
            .set(weight).equalTo(row::getWeight)
            .set(img).equalTo(row::getImg)
            .set(stockAmount).equalTo(row::getStockAmount)
            .set(saleAmount).equalTo(row::getSaleAmount)
            .set(reviewCount).equalTo(row::getReviewCount)
            .set(reviewValidCount).equalTo(row::getReviewValidCount)
            .set(reviewAverage).equalTo(row::getReviewAverage)
            .set(insaleStatus).equalTo(row::getInsaleStatus)
            .set(favorStatus).equalTo(row::getFavorStatus)
            .set(auditStatus).equalTo(row::getAuditStatus)
            .set(saleTime).equalTo(row::getSaleTime)
            .set(intro).equalTo(row::getIntro)
            .set(alertAmount).equalTo(row::getAlertAmount)
            .set(usableAmount).equalTo(row::getUsableAmount)
            .set(noStock).equalTo(row::getNoStock)
            .set(maker).equalTo(row::getMaker)
            .set(sort).equalTo(row::getSort)
            .set(quotaAmount).equalTo(row::getQuotaAmount)
            .set(bissnessType).equalTo(row::getBissnessType)
            .set(purchaserCode).equalTo(row::getPurchaserCode)
            .set(unSaleTime).equalTo(row::getUnSaleTime)
            .set(videoPath).equalTo(row::getVideoPath)
            .set(videoBanner).equalTo(row::getVideoBanner)
            .set(createUser).equalTo(row::getCreateUser)
            .set(createTime).equalTo(row::getCreateTime)
            .set(updateUser).equalTo(row::getUpdateUser)
            .set(updateTime).equalTo(row::getUpdateTime)
            .set(isDel).equalTo(row::getIsDel)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(MdProduct row) {
        return update(c ->
            c.set(productCode).equalToWhenPresent(row::getProductCode)
            .set(cateId).equalToWhenPresent(row::getCateId)
            .set(cateName).equalToWhenPresent(row::getCateName)
            .set(brandCode).equalToWhenPresent(row::getBrandCode)
            .set(brandName).equalToWhenPresent(row::getBrandName)
            .set(productType).equalToWhenPresent(row::getProductType)
            .set(supplierCode).equalToWhenPresent(row::getSupplierCode)
            .set(productName).equalToWhenPresent(row::getProductName)
            .set(nameInitials).equalToWhenPresent(row::getNameInitials)
            .set(mktPrice).equalToWhenPresent(row::getMktPrice)
            .set(purchasingPrice).equalToWhenPresent(row::getPurchasingPrice)
            .set(price).equalToWhenPresent(row::getPrice)
            .set(tempPrice).equalToWhenPresent(row::getTempPrice)
            .set(priceUnit).equalToWhenPresent(row::getPriceUnit)
            .set(weight).equalToWhenPresent(row::getWeight)
            .set(img).equalToWhenPresent(row::getImg)
            .set(stockAmount).equalToWhenPresent(row::getStockAmount)
            .set(saleAmount).equalToWhenPresent(row::getSaleAmount)
            .set(reviewCount).equalToWhenPresent(row::getReviewCount)
            .set(reviewValidCount).equalToWhenPresent(row::getReviewValidCount)
            .set(reviewAverage).equalToWhenPresent(row::getReviewAverage)
            .set(insaleStatus).equalToWhenPresent(row::getInsaleStatus)
            .set(favorStatus).equalToWhenPresent(row::getFavorStatus)
            .set(auditStatus).equalToWhenPresent(row::getAuditStatus)
            .set(saleTime).equalToWhenPresent(row::getSaleTime)
            .set(intro).equalToWhenPresent(row::getIntro)
            .set(alertAmount).equalToWhenPresent(row::getAlertAmount)
            .set(usableAmount).equalToWhenPresent(row::getUsableAmount)
            .set(noStock).equalToWhenPresent(row::getNoStock)
            .set(maker).equalToWhenPresent(row::getMaker)
            .set(sort).equalToWhenPresent(row::getSort)
            .set(quotaAmount).equalToWhenPresent(row::getQuotaAmount)
            .set(bissnessType).equalToWhenPresent(row::getBissnessType)
            .set(purchaserCode).equalToWhenPresent(row::getPurchaserCode)
            .set(unSaleTime).equalToWhenPresent(row::getUnSaleTime)
            .set(videoPath).equalToWhenPresent(row::getVideoPath)
            .set(videoBanner).equalToWhenPresent(row::getVideoBanner)
            .set(createUser).equalToWhenPresent(row::getCreateUser)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(updateUser).equalToWhenPresent(row::getUpdateUser)
            .set(updateTime).equalToWhenPresent(row::getUpdateTime)
            .set(isDel).equalToWhenPresent(row::getIsDel)
            .where(id, isEqualTo(row::getId))
        );
    }
}