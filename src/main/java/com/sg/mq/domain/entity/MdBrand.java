package com.sg.mq.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.annotation.Generated;

public class MdBrand implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String brandName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String brandImg;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String url;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String description;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer sort;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer enable;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String resellerLevel;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer recommend;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String createUser;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String updateUser;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime updateTime;

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
    public String getBrandName() {
        return brandName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getBrandImg() {
        return brandImg;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBrandImg(String brandImg) {
        this.brandImg = brandImg;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUrl() {
        return url;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUrl(String url) {
        this.url = url;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getDescription() {
        return description;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDescription(String description) {
        this.description = description;
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
    public Integer getEnable() {
        return enable;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getResellerLevel() {
        return resellerLevel;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setResellerLevel(String resellerLevel) {
        this.resellerLevel = resellerLevel;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getRecommend() {
        return recommend;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
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

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", brandName=").append(brandName);
        sb.append(", brandImg=").append(brandImg);
        sb.append(", url=").append(url);
        sb.append(", description=").append(description);
        sb.append(", sort=").append(sort);
        sb.append(", enable=").append(enable);
        sb.append(", resellerLevel=").append(resellerLevel);
        sb.append(", recommend=").append(recommend);
        sb.append(", createUser=").append(createUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}