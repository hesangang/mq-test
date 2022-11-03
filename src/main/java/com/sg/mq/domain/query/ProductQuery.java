package com.sg.mq.domain.query;

import com.sg.mq.domain.model.PageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author sangang
 * @since 2022-11-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Schema(name="商品")
public class ProductQuery extends PageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "ID")
    private String id;

    @Schema(description = "商品编码")
    private String productCode;

    @Schema(description = "品类编码")
    private String cateId;

    @Schema(description = "品类名称")
    private String cateName;

    @Schema(description = "品牌编码")
    private String brandCode;

    @Schema(description = "品牌名称")
    private String brandName;

    @Schema(description = "产品类型")
    private String productType;

    @Schema(description = "商家名称")
    private String supplierCode;

    @Schema(description = "商品名称")
    private String productName;

    @Schema(description = "名称首字母")
    private String nameInitials;

    @Schema(description = "市场价")
    private BigDecimal mktPrice;

    @Schema(description = "购买价格")
    private BigDecimal purchasingPrice;

    @Schema(description = "价格")
    private BigDecimal price;

    @Schema(description = "竞价临时价格")
    private BigDecimal tempPrice;

    @Schema(description = "价格单位")
    private String priceUnit;

    @Schema(description = "重量")
    private BigDecimal weight;

    @Schema(description = "图片")
    private String img;

    @Schema(description = "实际库存量")
    private Integer stockAmount;

    @Schema(description = "销售量")
    private Integer saleAmount;

    @Schema(description = "评论总数")
    private Integer reviewCount;

    @Schema(description = "有效评论数量")
    private Integer reviewValidCount;

    @Schema(description = "评论平均分")
    private BigDecimal reviewAverage;

    @Schema(description = "是否上架 0：下架 1：上架 2：停售")
    private Integer insaleStatus;

    @Schema(description = "是否参与优惠：0否，1是")
    private Integer favorStatus;

    @Schema(description = "是否审核 0:待审核 1：审核通过 2：审核不通过")
    private Integer auditStatus;

    @Schema(description = "上架时间")
    private Date saleTime;

    @Schema(description = "产品介绍")
    private String intro;

    @Schema(description = "商品预警数量")
    private Integer alertAmount;

    @Schema(description = "可用库存")
    private Integer usableAmount;

    @Schema(description = "是否零库存产品 0：否 1：是")
    private Integer noStock;

    @Schema(description = "生产企业")
    private String maker;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "限购数量")
    private Integer quotaAmount;

    @Schema(description = "业务类型 0：普通 1：自营 2：寄售")
    private Integer bissnessType;

    @Schema(description = "采购商编码")
    private String purchaserCode;

    @Schema(description = "下架时间")
    private Date unSaleTime;

    @Schema(description = "视频地址")
    private String videoPath;

    @Schema(description = "视频封面")
    private String videoBanner;

    @Schema(description = "创建人")
    private String createUser;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "更新人")
    private String updateUser;

    @Schema(description = "更新时间")
    private Date updateTime;

    @Schema(description = "更新时间")
    private Date updateTimeMin;

    @Schema(description = "更新时间")
    private Date updateTimeMax;


}
