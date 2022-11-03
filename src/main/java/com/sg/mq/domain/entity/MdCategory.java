package com.sg.mq.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.annotation.Generated;

public class MdCategory implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String parentId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String categoryName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String categoryCode;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String categoryType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer status;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer sort;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String updateUser;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String createUser;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime createTime;

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
    public String getParentId() {
        return parentId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCategoryName() {
        return categoryName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCategoryCode() {
        return categoryCode;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCategoryType() {
        return categoryType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getStatus() {
        return status;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStatus(Integer status) {
        this.status = status;
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

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", categoryCode=").append(categoryCode);
        sb.append(", categoryType=").append(categoryType);
        sb.append(", status=").append(status);
        sb.append(", sort=").append(sort);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}