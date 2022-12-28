package com.sg.mq.domain.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author sangang
 */

@Data
public class PageQuery<T> implements Serializable {

    private List<String> lastSort;

    private String pitId;

    private int pageSize = 10;

    private int page = 1;

}
