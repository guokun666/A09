package com.boot.demo.entity;

import lombok.Data;

@Data
public class TrainsRealTimeEntity {
    private Integer tid;
    private Long timeStamp;
    private Integer tSpeed;
    private String lastStation;
    private String nextStation;
    private Integer isRun;
    private Integer tWeight;
}
