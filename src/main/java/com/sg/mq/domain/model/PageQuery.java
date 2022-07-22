package com.sg.mq.domain.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author sangang
 */

@Data
public class PageQuery<T> implements Serializable {

    private int pageSize = 10;

    private int page = 1;

}
