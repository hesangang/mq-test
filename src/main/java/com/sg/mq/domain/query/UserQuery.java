package com.sg.mq.domain.query;

import com.sg.mq.domain.model.PageQuery;
import com.sg.mq.domain.validation.annotaion.Phone;
import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * @Description 用户 检索参数类
 * </p>
 *
 * @author SanGang
 * @since 2021-05-11
 * @version 2.0
 */
@Data
@ApiModel(description="用户")
public class UserQuery extends PageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 4,max = 20, message = "【用户账号】最小4位数,最大20位数")
    @Schema(description = "用户账号")
    private String userName;

    @Schema(description = "手机号")
    @Phone(message = "手机号不正确")
    private String phone;

    @Schema(description = "用户昵称")
    private String nickName;

    @Schema(description = "更新时间-起")
    private LocalDateTime updateTimeMin;

    @Schema(description = "更新时间-止")
    private LocalDateTime updateTimeMax;

}
