package com.sg.mq.domain.model;

import java.io.Serializable;

public class JResult<T> implements Serializable {

    private long code;
    private String msg;
    private T data;
    private long time = System.currentTimeMillis() / 1000L;;

    protected JResult() {
    }

    protected JResult(long code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> JResult<T> success() {
        return new JResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> JResult<T> success(T data) {
        return new JResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> JResult<T> success(T data, String message) {
        return new JResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> JResult<T> failed(IErrorCode errorCode) {
        return new JResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     * @param message 错误信息
     */
    public static <T> JResult<T> failed(IErrorCode errorCode, String message) {
        return new JResult<T>(errorCode.getCode(), message, null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> JResult<T> failed(String message) {
        return new JResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> JResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> JResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> JResult<T> validateFailed(String message) {
        return new JResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> JResult<T> unauthorized(T data) {
        return new JResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> JResult<T> forbidden(T data) {
        return new JResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

