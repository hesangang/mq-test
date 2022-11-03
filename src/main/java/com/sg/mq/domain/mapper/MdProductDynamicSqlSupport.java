package com.sg.mq.domain.mapper;

import java.math.BigDecimal;
import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class MdProductDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final MdProduct mdProduct = new MdProduct();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> id = mdProduct.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> productCode = mdProduct.productCode;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> cateId = mdProduct.cateId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> cateName = mdProduct.cateName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> brandCode = mdProduct.brandCode;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> brandName = mdProduct.brandName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> productType = mdProduct.productType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> supplierCode = mdProduct.supplierCode;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> productName = mdProduct.productName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> nameInitials = mdProduct.nameInitials;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> mktPrice = mdProduct.mktPrice;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> purchasingPrice = mdProduct.purchasingPrice;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> price = mdProduct.price;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> tempPrice = mdProduct.tempPrice;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> priceUnit = mdProduct.priceUnit;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> weight = mdProduct.weight;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> img = mdProduct.img;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> stockAmount = mdProduct.stockAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> saleAmount = mdProduct.saleAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> reviewCount = mdProduct.reviewCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> reviewValidCount = mdProduct.reviewValidCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> reviewAverage = mdProduct.reviewAverage;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> insaleStatus = mdProduct.insaleStatus;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> favorStatus = mdProduct.favorStatus;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> auditStatus = mdProduct.auditStatus;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> saleTime = mdProduct.saleTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> intro = mdProduct.intro;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> alertAmount = mdProduct.alertAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> usableAmount = mdProduct.usableAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> noStock = mdProduct.noStock;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> maker = mdProduct.maker;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> sort = mdProduct.sort;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> quotaAmount = mdProduct.quotaAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> bissnessType = mdProduct.bissnessType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> purchaserCode = mdProduct.purchaserCode;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> unSaleTime = mdProduct.unSaleTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> videoPath = mdProduct.videoPath;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> videoBanner = mdProduct.videoBanner;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> createUser = mdProduct.createUser;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> createTime = mdProduct.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> updateUser = mdProduct.updateUser;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> updateTime = mdProduct.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> isDel = mdProduct.isDel;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class MdProduct extends AliasableSqlTable<MdProduct> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> productCode = column("product_code", JDBCType.VARCHAR);

        public final SqlColumn<String> cateId = column("cate_id", JDBCType.VARCHAR);

        public final SqlColumn<String> cateName = column("cate_name", JDBCType.VARCHAR);

        public final SqlColumn<String> brandCode = column("brand_code", JDBCType.VARCHAR);

        public final SqlColumn<String> brandName = column("brand_name", JDBCType.VARCHAR);

        public final SqlColumn<String> productType = column("product_type", JDBCType.VARCHAR);

        public final SqlColumn<String> supplierCode = column("supplier_code", JDBCType.VARCHAR);

        public final SqlColumn<String> productName = column("product_name", JDBCType.VARCHAR);

        public final SqlColumn<String> nameInitials = column("name_initials", JDBCType.VARCHAR);

        public final SqlColumn<BigDecimal> mktPrice = column("mkt_price", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> purchasingPrice = column("purchasing_price", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> price = column("price", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> tempPrice = column("temp_price", JDBCType.DECIMAL);

        public final SqlColumn<String> priceUnit = column("price_unit", JDBCType.VARCHAR);

        public final SqlColumn<BigDecimal> weight = column("weight", JDBCType.DECIMAL);

        public final SqlColumn<String> img = column("img", JDBCType.VARCHAR);

        public final SqlColumn<Integer> stockAmount = column("stock_amount", JDBCType.INTEGER);

        public final SqlColumn<Integer> saleAmount = column("sale_amount", JDBCType.INTEGER);

        public final SqlColumn<Integer> reviewCount = column("review_count", JDBCType.INTEGER);

        public final SqlColumn<Integer> reviewValidCount = column("review_valid_count", JDBCType.INTEGER);

        public final SqlColumn<BigDecimal> reviewAverage = column("review_average", JDBCType.DECIMAL);

        public final SqlColumn<Integer> insaleStatus = column("insale_status", JDBCType.INTEGER);

        public final SqlColumn<Integer> favorStatus = column("favor_status", JDBCType.INTEGER);

        public final SqlColumn<Integer> auditStatus = column("audit_status", JDBCType.INTEGER);

        public final SqlColumn<LocalDateTime> saleTime = column("sale_time", JDBCType.TIMESTAMP);

        public final SqlColumn<String> intro = column("intro", JDBCType.VARCHAR);

        public final SqlColumn<Integer> alertAmount = column("alert_amount", JDBCType.INTEGER);

        public final SqlColumn<Integer> usableAmount = column("usable_amount", JDBCType.INTEGER);

        public final SqlColumn<Integer> noStock = column("no_stock", JDBCType.INTEGER);

        public final SqlColumn<String> maker = column("maker", JDBCType.VARCHAR);

        public final SqlColumn<Integer> sort = column("sort", JDBCType.INTEGER);

        public final SqlColumn<Integer> quotaAmount = column("quota_amount", JDBCType.INTEGER);

        public final SqlColumn<Integer> bissnessType = column("bissness_type", JDBCType.INTEGER);

        public final SqlColumn<String> purchaserCode = column("purchaser_code", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> unSaleTime = column("un_sale_time", JDBCType.TIMESTAMP);

        public final SqlColumn<String> videoPath = column("video_path", JDBCType.VARCHAR);

        public final SqlColumn<String> videoBanner = column("video_banner", JDBCType.VARCHAR);

        public final SqlColumn<String> createUser = column("create_user", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<String> updateUser = column("update_user", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> isDel = column("is_del", JDBCType.INTEGER);

        public MdProduct() {
            super("md_product", MdProduct::new);
        }
    }
}