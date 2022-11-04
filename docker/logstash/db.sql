-- es_db.md_brand definition

CREATE TABLE `md_brand` (
                            `id` varchar(50) NOT NULL COMMENT 'ID',
                            `brand_name` varchar(128) NOT NULL COMMENT '品牌名称',
                            `brand_img` varchar(100) DEFAULT NULL COMMENT '品牌图片',
                            `url` varchar(100) DEFAULT NULL COMMENT '品牌地址',
                            `description` varchar(100) DEFAULT NULL COMMENT '品牌描述',
                            `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
                            `enable` int(11) NOT NULL DEFAULT '0' COMMENT '是否启用：0否，1是',
                            `reseller_level` varchar(20) DEFAULT NULL COMMENT '品牌代理级别',
                            `recommend` int(11) NOT NULL DEFAULT '0' COMMENT '品牌是否推荐 0:否 1:是',
                            `create_user` varchar(50) NOT NULL COMMENT '创建人',
                            `create_time` datetime NOT NULL COMMENT '创建时间',
                            `update_user` varchar(50) NOT NULL COMMENT '更新人',
                            `update_time` datetime NOT NULL COMMENT '更新时间',
                            `is_del` int(1) NOT NULL DEFAULT '0' COMMENT '删除标识：0否，1是',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='品牌';


-- es_db.md_category definition

CREATE TABLE `md_category` (
                               `id` varchar(50) NOT NULL COMMENT '主键ID',
                               `parent_id` varchar(50) NOT NULL DEFAULT '0' COMMENT '所属类别ID',
                               `category_name` varchar(30) NOT NULL COMMENT '品类名称',
                               `category_code` varchar(30) NOT NULL COMMENT '品类编码',
                               `category_type` varchar(30) NOT NULL COMMENT '类型',
                               `status` int(2) NOT NULL DEFAULT '0' COMMENT '状态  0-无效,1-启用,2-停用,3-新建',
                               `sort` int(3) NOT NULL DEFAULT '0' COMMENT '排序',
                               `update_user` varchar(32) DEFAULT NULL COMMENT '操作人',
                               `update_time` datetime DEFAULT NULL COMMENT '操作时间',
                               `create_user` varchar(255) DEFAULT NULL COMMENT '创建人',
                               `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                               `is_del` int(1) NOT NULL DEFAULT '0' COMMENT '删除标识：0否，1是',
                               PRIMARY KEY (`id`),
                               UNIQUE KEY `md_category_code_IDX` (`category_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='品类';


-- es_db.md_product definition

CREATE TABLE `md_product` (
                              `id` varchar(50) NOT NULL COMMENT 'ID',
                              `product_code` varchar(100) NOT NULL COMMENT '商品编码',
                              `cate_id` varchar(100) NOT NULL COMMENT '品类编码',
                              `cate_name` varchar(100) NOT NULL COMMENT '品类名称',
                              `brand_code` varchar(100) NOT NULL COMMENT '品牌编码',
                              `brand_name` varchar(100) NOT NULL COMMENT '品牌名称',
                              `product_type` varchar(100) NOT NULL COMMENT '产品类型',
                              `supplier_code` varchar(100) NOT NULL COMMENT '商家名称',
                              `product_name` varchar(100) NOT NULL COMMENT '商品名称',
                              `name_initials` varchar(1) NOT NULL COMMENT '名称首字母',
                              `mkt_price` decimal(10,0) DEFAULT NULL COMMENT '市场价',
                              `purchasing_price` decimal(10,0) DEFAULT NULL COMMENT '购买价格',
                              `price` decimal(10,0) DEFAULT NULL COMMENT '价格',
                              `temp_price` decimal(10,0) DEFAULT NULL COMMENT '竞价临时价格',
                              `price_unit` varchar(20) DEFAULT NULL COMMENT '价格单位',
                              `weight` decimal(10,0) DEFAULT NULL COMMENT '重量',
                              `img` varchar(100) DEFAULT NULL COMMENT '图片',
                              `stock_amount` int(11) NOT NULL DEFAULT '0' COMMENT '实际库存量',
                              `sale_amount` int(11) NOT NULL DEFAULT '0' COMMENT '销售量',
                              `review_count` int(11) NOT NULL DEFAULT '0' COMMENT '评论总数',
                              `review_valid_count` int(11) NOT NULL DEFAULT '0' COMMENT '有效评论数量',
                              `review_average` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '评论平均分',
                              `insale_status` int(11) NOT NULL DEFAULT '0' COMMENT '是否上架 0：下架 1：上架 2：停售',
                              `favor_status` int(11) NOT NULL DEFAULT '0' COMMENT '是否参与优惠：0否，1是',
                              `audit_status` int(11) NOT NULL DEFAULT '0' COMMENT '是否审核 0:待审核 1：审核通过 2：审核不通过',
                              `sale_time` datetime DEFAULT NULL COMMENT '上架时间',
                              `intro` varchar(100) DEFAULT NULL COMMENT '产品介绍',
                              `alert_amount` int(11) DEFAULT NULL COMMENT '商品预警数量',
                              `usable_amount` int(11) NOT NULL DEFAULT '0' COMMENT '可用库存',
                              `no_stock` int(11) NOT NULL DEFAULT '0' COMMENT '是否零库存产品 0：否 1：是',
                              `maker` varchar(100) DEFAULT NULL COMMENT '生产企业',
                              `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
                              `quota_amount` int(11) DEFAULT NULL COMMENT '限购数量',
                              `bissness_type` int(11) NOT NULL DEFAULT '0' COMMENT '业务类型 0：普通 1：自营 2：寄售',
                              `purchaser_code` varchar(100) DEFAULT NULL COMMENT '采购商编码',
                              `un_sale_time` datetime DEFAULT NULL COMMENT '下架时间',
                              `video_path` varchar(100) DEFAULT NULL COMMENT '视频地址',
                              `video_banner` varchar(100) DEFAULT NULL COMMENT '视频封面',
                              `create_user` varchar(50) NOT NULL COMMENT '创建人',
                              `create_time` datetime NOT NULL COMMENT '创建时间',
                              `update_user` varchar(50) NOT NULL COMMENT '更新人',
                              `update_time` datetime NOT NULL COMMENT '更新时间',
                              `is_del` int(1) NOT NULL DEFAULT '0' COMMENT '删除标识：0否，1是',
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `md_product_UN` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品';


-- es_db.sys_user definition

CREATE TABLE `sys_user` (
                            `id` varchar(50) NOT NULL COMMENT '用户ID',
                            `user_name` varchar(30) NOT NULL COMMENT '用户账号',
                            `nick_name` varchar(100) DEFAULT NULL COMMENT '用户昵称',
                            `user_type` int(2) NOT NULL DEFAULT '0' COMMENT '用户类型',
                            `email` varchar(50) DEFAULT NULL COMMENT '用户邮箱',
                            `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
                            `sex` int(1) NOT NULL DEFAULT '2' COMMENT '用户性别（0男 1女 2未知）',
                            `avatar` varchar(100) NOT NULL DEFAULT 'x' COMMENT '头像地址',
                            `password` varchar(100) NOT NULL COMMENT '密码',
                            `status` int(1) NOT NULL DEFAULT '1' COMMENT '帐号状态（1正常 0停用）',
                            `is_del` int(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0存在 1删除）',
                            `create_user` varchar(64) NOT NULL COMMENT '创建者',
                            `create_time` datetime NOT NULL COMMENT '创建时间',
                            `update_user` varchar(64) NOT NULL COMMENT '更新者',
                            `update_time` datetime NOT NULL COMMENT '更新时间',
                            `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                            `expiration_date` date DEFAULT NULL COMMENT '失效日期',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户';