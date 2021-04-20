package com.boot.demo.entity;

import lombok.Data;

@Data
public class TrainOnlineBarEntity {
    private String line;
    private Integer notOnlineNumber;
    private Integer onlineNumber;
}
