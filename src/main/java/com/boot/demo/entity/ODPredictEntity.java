package com.boot.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude
        (JsonInclude.Include.NON_NULL)
@Data
@ApiModel("OD客流结果表预测实体类")
public class ODPredictEntity {//
    @ApiModelProperty("预测范围")
    private Integer day;//y_day
    @ApiModelProperty("起点")
    private String origin;//
    @ApiModelProperty("终点")
    private String destination;//
    @ApiModelProperty("客流")
    private Integer flow;//
    @ApiModelProperty("线路")
    private String line;//
}
