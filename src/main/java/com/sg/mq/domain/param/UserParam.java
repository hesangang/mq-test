package com.sg.mq.domain.param;

import com.sg.mq.domain.model.PageQuery;
import com.sg.mq.domain.validation.annotaion.Phone;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * 用户信息
 *
 * @author sangang
 * @version 1.0
 * date 2021/3/29 10:53
 */
@Schema(name = "用户入参")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserParam extends PageQuery implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 6885915526714692655L;

    @Schema(description = "用户id")
    private Long id;

    @NotNull
    @Size(min = 4,max = 20, message = "【用户名】最小4位数,最大20位数")
    @Schema(description = "用户名")
    private String userName;

    @Size(min = 6,max = 20, message = "【用户密码】最小6位数,最大20位数")
    @Schema(description = "用户密码",example = "123456")
    private String password;

    @Max(value = 999, message = "【年龄】最大不能超过999")
    @Schema(description = "年龄")
    private Integer age;

    @Schema(description = "手机号",example = "1731052102")
    @Phone(message = "手机号不正确")
    private String phone;

    @Size(max = 50, message = "【用户地址】最大不能超过50个长度")
    @Schema(description = "用户地址")
    private String address;

}
