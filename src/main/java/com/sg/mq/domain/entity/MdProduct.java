package com.sg.mq.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.Generated;

public class MdProduct implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String productCode;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String cateId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String cateName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String brandCode;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String brandName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String productType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String supplierCode;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String productName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String nameInitials;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal mktPrice;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal purchasingPrice;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal price;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal tempPrice;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String priceUnit;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal weight;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String img;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer stockAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer saleAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer reviewCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer reviewValidCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal reviewAverage;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer insaleStatus;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer favorStatus;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer auditStatus;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime saleTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String intro;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer alertAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer usableAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer noStock;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String maker;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer sort;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer quotaAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer bissnessType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String purchaserCode;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime unSaleTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String videoPath;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String videoBanner;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String createUser;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String updateUser;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer isDel;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(String id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getProductCode() {
        return productCode;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCateId() {
        return cateId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCateName() {
        return cateName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getBrandCode() {
        return brandCode;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getBrandName() {
        return brandName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getProductType() {
        return productType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getSupplierCode() {
        return supplierCode;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getProductName() {
        return productName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getNameInitials() {
        return nameInitials;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setNameInitials(String nameInitials) {
        this.nameInitials = nameInitials;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getMktPrice() {
        return mktPrice;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMktPrice(BigDecimal mktPrice) {
        this.mktPrice = mktPrice;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getPurchasingPrice() {
        return purchasingPrice;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPurchasingPrice(BigDecimal purchasingPrice) {
        this.purchasingPrice = purchasingPrice;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getPrice() {
        return price;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getTempPrice() {
        return tempPrice;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTempPrice(BigDecimal tempPrice) {
        this.tempPrice = tempPrice;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPriceUnit() {
        return priceUnit;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getWeight() {
        return weight;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getImg() {
        return img;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setImg(String img) {
        this.img = img;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getStockAmount() {
        return stockAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStockAmount(Integer stockAmount) {
        this.stockAmount = stockAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getSaleAmount() {
        return saleAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSaleAmount(Integer saleAmount) {
        this.saleAmount = saleAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getReviewCount() {
        return reviewCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getReviewValidCount() {
        return reviewValidCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setReviewValidCount(Integer reviewValidCount) {
        this.reviewValidCount = reviewValidCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getReviewAverage() {
        return reviewAverage;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setReviewAverage(BigDecimal reviewAverage) {
        this.reviewAverage = reviewAverage;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getInsaleStatus() {
        return insaleStatus;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setInsaleStatus(Integer insaleStatus) {
        this.insaleStatus = insaleStatus;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getFavorStatus() {
        return favorStatus;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setFavorStatus(Integer favorStatus) {
        this.favorStatus = favorStatus;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getAuditStatus() {
        return auditStatus;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getSaleTime() {
        return saleTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSaleTime(LocalDateTime saleTime) {
        this.saleTime = saleTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getIntro() {
        return intro;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getAlertAmount() {
        return alertAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAlertAmount(Integer alertAmount) {
        this.alertAmount = alertAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getUsableAmount() {
        return usableAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUsableAmount(Integer usableAmount) {
        this.usableAmount = usableAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getNoStock() {
        return noStock;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setNoStock(Integer noStock) {
        this.noStock = noStock;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getMaker() {
        return maker;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMaker(String maker) {
        this.maker = maker;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getSort() {
        return sort;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getQuotaAmount() {
        return quotaAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setQuotaAmount(Integer quotaAmount) {
        this.quotaAmount = quotaAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getBissnessType() {
        return bissnessType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBissnessType(Integer bissnessType) {
        this.bissnessType = bissnessType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPurchaserCode() {
        return purchaserCode;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPurchaserCode(String purchaserCode) {
        this.purchaserCode = purchaserCode;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getUnSaleTime() {
        return unSaleTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUnSaleTime(LocalDateTime unSaleTime) {
        this.unSaleTime = unSaleTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getVideoPath() {
        return videoPath;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getVideoBanner() {
        return videoBanner;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setVideoBanner(String videoBanner) {
        this.videoBanner = videoBanner;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCreateUser() {
        return createUser;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUpdateUser() {
        return updateUser;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getIsDel() {
        return isDel;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productCode=").append(productCode);
        sb.append(", cateId=").append(cateId);
        sb.append(", cateName=").append(cateName);
        sb.append(", brandCode=").append(brandCode);
        sb.append(", brandName=").append(brandName);
        sb.append(", productType=").append(productType);
        sb.append(", supplierCode=").append(supplierCode);
        sb.append(", productName=").append(productName);
        sb.append(", nameInitials=").append(nameInitials);
        sb.append(", mktPrice=").append(mktPrice);
        sb.append(", purchasingPrice=").append(purchasingPrice);
        sb.append(", price=").append(price);
        sb.append(", tempPrice=").append(tempPrice);
        sb.append(", priceUnit=").append(priceUnit);
        sb.append(", weight=").append(weight);
        sb.append(", img=").append(img);
        sb.append(", stockAmount=").append(stockAmount);
        sb.append(", saleAmount=").append(saleAmount);
        sb.append(", reviewCount=").append(reviewCount);
        sb.append(", reviewValidCount=").append(reviewValidCount);
        sb.append(", reviewAverage=").append(reviewAverage);
        sb.append(", insaleStatus=").append(insaleStatus);
        sb.append(", favorStatus=").append(favorStatus);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", saleTime=").append(saleTime);
        sb.append(", intro=").append(intro);
        sb.append(", alertAmount=").append(alertAmount);
        sb.append(", usableAmount=").append(usableAmount);
        sb.append(", noStock=").append(noStock);
        sb.append(", maker=").append(maker);
        sb.append(", sort=").append(sort);
        sb.append(", quotaAmount=").append(quotaAmount);
        sb.append(", bissnessType=").append(bissnessType);
        sb.append(", purchaserCode=").append(purchaserCode);
        sb.append(", unSaleTime=").append(unSaleTime);
        sb.append(", videoPath=").append(videoPath);
        sb.append(", videoBanner=").append(videoBanner);
        sb.append(", createUser=").append(createUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}