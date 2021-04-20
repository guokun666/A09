package com.boot.demo.entity;

import lombok.Data;

@Data
public class TrainsEntity {
    private Integer tid;
    private String line;
    private Integer isOnline;
    private String originStation;
    private String terminus;
}
