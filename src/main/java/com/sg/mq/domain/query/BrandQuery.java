package com.sg.mq.domain.query;

import com.sg.mq.domain.model.PageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 品牌
 * </p>
 *
 * @author sangang
 * @since 2022-11-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Schema(name="品牌")
public class BrandQuery extends PageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "ID")
    private String id;

    @Schema(description = "品牌名称")
    private String brandName;

    @Schema(description = "品牌图片")
    private String brandImg;

    @Schema(description = "品牌地址")
    private String url;

    @Schema(description = "品牌描述")
    private String description;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "是否启用：0否，1是")
    private Integer enable;

    @Schema(description = "品牌代理级别")
    private String resellerLevel;

    @Schema(description = "品牌是否推荐 0:否 1:是")
    private Integer recommend;

    @Schema(description = "创建人")
    private String createUser;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新人")
    private String updateUser;

    @Schema(description = "更新时间")
    private LocalDateTime updateTimeMin;

    @Schema(description = "更新时间")
    private LocalDateTime updateTimeMax;


}
