package com.boot.demo.entity;

import lombok.Data;

@Data
public class StationRealTimeEntity {
    private String stationName;
    private Integer trainFlow;
    private Integer flowIn;
    private Integer flowOut;
    private String flowGrade;
}
