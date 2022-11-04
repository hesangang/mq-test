package com.sg.mq.domain.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class MdCategoryDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final MdCategory mdCategory = new MdCategory();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> id = mdCategory.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> parentId = mdCategory.parentId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> categoryName = mdCategory.categoryName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> categoryCode = mdCategory.categoryCode;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> categoryType = mdCategory.categoryType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> status = mdCategory.status;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> sort = mdCategory.sort;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> updateUser = mdCategory.updateUser;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> updateTime = mdCategory.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> createUser = mdCategory.createUser;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> createTime = mdCategory.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> isDel = mdCategory.isDel;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class MdCategory extends AliasableSqlTable<MdCategory> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> parentId = column("parent_id", JDBCType.VARCHAR);

        public final SqlColumn<String> categoryName = column("category_name", JDBCType.VARCHAR);

        public final SqlColumn<String> categoryCode = column("category_code", JDBCType.VARCHAR);

        public final SqlColumn<String> categoryType = column("category_type", JDBCType.VARCHAR);

        public final SqlColumn<Integer> status = column("status", JDBCType.INTEGER);

        public final SqlColumn<Integer> sort = column("sort", JDBCType.INTEGER);

        public final SqlColumn<String> updateUser = column("update_user", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<String> createUser = column("create_user", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> isDel = column("is_del", JDBCType.INTEGER);

        public MdCategory() {
            super("md_category", MdCategory::new);
        }
    }
}