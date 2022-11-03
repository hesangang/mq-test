package com.sg.mq.service.impl;

import cn.hutool.core.util.StrUtil;
import com.sg.mq.domain.constant.SecurityConstant;
import com.sg.mq.domain.util.IDGeneratorUtils;
import com.sg.mq.domain.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * @Description 业务基础类
 * </p>
 *
 * @author sangang
 * @since 2019-07-14
 * @version 2.0
 */
public abstract class BaseService {

    @Autowired
    public HttpServletRequest request;

    protected UserVo getUser() {
        return (UserVo)request.getSession().getAttribute(SecurityConstant.USER_TOKEN_HEADER);
    }

    public String getUserId() {
        if(getUser() == null){
            return null;
        }
        return getUser().getId();
    }
    public String getUserName() {
        if(getUser() == null){
            return null;
        }
        return getUser().getUserName();
    }

    public String getNo() {
        return StrUtil.toString(IDGeneratorUtils.getLongId());
    }

    public Long getLongId() {
        return IDGeneratorUtils.getLongId();
    }

    public boolean retBool(Integer result){
        return null != result && result >= 1;
    }

    public String like(String s) {
        return "%" + s + "%";
    }

}
