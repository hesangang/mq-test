package com.sg.mq.controller;


import com.sg.mq.domain.model.JResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * controller的父类
 *
 * @author sangang
 * @create 2018-04-27
 */
public class BaseController {

    protected static <T> JResult<T> error(String msg) {
        return JResult.failed(msg);
    }

    protected <T> JResult<T> fail(String msg) {
        return JResult.failed(msg);
    }

    protected <T> JResult<T> success(T data) {
        return JResult.success(data);
    }

    protected <T> JResult<T> success() {
        return JResult.success();
    }

    // 获取当前的活动请求。
    private HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }
}
