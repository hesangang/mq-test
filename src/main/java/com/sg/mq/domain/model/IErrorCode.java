package com.sg.mq.domain.model;

/**
 * 封装API的错误码
 * Created by sangang
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
