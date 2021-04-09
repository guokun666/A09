package com.boot.demo.components.common.base;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class BaseBO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int pageNo = 1;

    private int pageSize = 10;

}
