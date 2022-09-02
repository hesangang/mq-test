package com.sg.mq.domain.model;

/**
 * 枚举了一些常用API操作码
 * SanGang
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "服务端异常"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "未登录或已过期"),
    FORBIDDEN(403, "没有相关权限");
    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}