package com.boot.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigInteger;

@JsonInclude
        (JsonInclude.Include.NON_NULL)
@Data
@ApiModel("早高峰客流结果表实体类e")
public class PeakEntity {//e
    @ApiModelProperty("年份")
    private Integer year;//e_year
    @ApiModelProperty("线路")
    private String singleline;//line
    @ApiModelProperty("客流")
    private Integer flow;//flow
    @ApiModelProperty("时间段")
    private String time;//time_slot
    @ApiModelProperty("早占比")
    private String moringpercentage;//percentage
    @ApiModelProperty("晚占比")
    private String eveningpercentage;//percentage
    @ApiModelProperty("月份")
    private Integer month;//e_month
}
