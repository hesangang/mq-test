package com.sg.mq.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.io.Serializable;

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
    private Long id;

    @Schema(description = "用户名")
    private String userName;

    @Schema(description = "用户密码",example = "123456")
    private String password;

    @Schema(description = "年龄")
    private Integer age;

    @Schema(description = "用户地址")
    private String address;
}
