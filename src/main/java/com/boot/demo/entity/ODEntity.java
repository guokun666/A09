package com.boot.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude
        (JsonInclude.Include.NON_NULL)
@Data
@ApiModel("OD客流结果表预测实体类")
public class ODEntity {//
    @ApiModelProperty("日期")
    private String day;//y_date
    @ApiModelProperty("起点")
    private String start_station;//
    @ApiModelProperty("终点")
    private String end_station;//
    @ApiModelProperty("客流")
    private Integer flow;//
    @ApiModelProperty("线路")
    private String line;//
}
