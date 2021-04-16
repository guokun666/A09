package com.boot.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude
        (JsonInclude.Include.NON_NULL)
@Data
@ApiModel("早高峰预测客流结果表实体类y")
public class PeakPreditcEntity {//y
    @ApiModelProperty("线路")
    private String line;//line
    @ApiModelProperty("客流")
    private Integer flow;//flow
    @ApiModelProperty("时间段")
    private String time;//time_attribute
}
