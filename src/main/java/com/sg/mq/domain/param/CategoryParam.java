package com.sg.mq.domain.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 品类
 * </p>
 *
 * @author sangang
 * @since 2022-11-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Schema(name="品类")
public class CategoryParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    private String id;

    @Schema(description = "所属类别ID")
    private String parentId;

    @Schema(description = "品类名称")
    private String categoryName;

    @Schema(description = "品类编码")
    private String categoryCode;

    @Schema(description = "类型")
    private String categoryType;

    @Schema(description = "状态  0-无效,1-启用,2-停用,3-新建")
    private Integer status;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "操作人")
    private String updateUser;

    @Schema(description = "操作时间")
    private Date updateTime;

    @Schema(description = "创建人")
    private String createUser;

    @Schema(description = "创建时间")
    private Date createTime;


}
