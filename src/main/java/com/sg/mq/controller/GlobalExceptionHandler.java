package com.sg.mq.controller;

import com.sg.mq.domain.exception.BusinessException;
import com.sg.mq.domain.model.JResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * @author sangang
 * @create 2018-08-17
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public JResult<String> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        return error(fieldError.getDefaultMessage());
    }

    @ExceptionHandler(value = BusinessException.class)
    public JResult<String> businessExceptionHandler(BusinessException exception) {
        logger.error("业务处理异常：", exception);
        return error(exception.getMessage());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public JResult<String> businessExceptionHandler(ConstraintViolationException exception) {
        if(exception.getMessage().contains(": ")){
            return error(exception.getMessage().substring(exception.getMessage().indexOf(":")+1).trim());
        }
        return error(exception.getMessage());
    }



    /**
     * 所有异常报错
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public JResult<String> allExceptionHandler(Exception exception) {
        logger.error("服务端异常", exception);
        return error("服务端异常");
    }
}
