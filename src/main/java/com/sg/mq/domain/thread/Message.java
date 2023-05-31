package com.sg.mq.domain.thread;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息内容
 * @title Message
 * @author zmzhou
 * @version 1.0
 * @date 2021/4/1 21:52
 */
@Data
@Builder
public class Message implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = -816325171354731549L;
    /** id */
    private Long id;

    /** 消息 */
    private String msg;

    /** 时间戳 */
    private Date timestamp;
}
