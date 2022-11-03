package com.sg.mq.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 用户信息
 *
 * @author sangang
 * @version 1.0
 * date 2021/3/29 10:53
 */
@Schema(name = "用户信息Vo")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVo implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 6885915526714692655L;

    @Schema(description = "用户id")
    private String id;

    @Schema(description = "用户账号")
    private String userName;

    @Schema(description = "用户昵称")
    private String nickName;

    @Schema(description = "用户类型")
    private Integer userType;

    @Schema(description = "用户邮箱")
    private String email;

    @Schema(description = "手机号码")
    private String phone;

    @Schema(description = "用户性别（0男 1女 2未知）")
    private Integer sex;

    @Schema(description = "头像地址")
    private String avatar;

    @Schema(description = "用户密码",example = "123456")
    private String password;

    @Schema(description = "帐号状态（1正常 0停用）")
    private Integer status;

    @Schema(description = "删除标志（0存在 1删除）")
    private Integer isDel;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "失效时间")
    private LocalDate expirationDate;

    @Schema(description = "创建人")
    private String createUser;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新人")
    private String updateUser;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;


}
