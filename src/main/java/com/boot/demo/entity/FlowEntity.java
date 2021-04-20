package com.boot.demo.entity;

import lombok.Data;

@Data
public class FlowEntity {
    private Integer flowIn;
    private Integer flowOut;
    private Integer flow;
    private String station;
    private String line;
}
