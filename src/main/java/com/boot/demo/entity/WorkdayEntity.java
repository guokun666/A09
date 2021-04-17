package com.boot.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigInteger;

@JsonInclude
        (JsonInclude.Include.NON_NULL)
@Data
@ApiModel("工作日与周末客流结果表实体类b")
public class WorkdayEntity {//b
    @ApiModelProperty("年份")
    private Integer year;//b_year
    @ApiModelProperty("线路")
    private String singleline;//line
    @ApiModelProperty("工作日日均进站流量")
    private BigInteger workday;//workday_average
    @ApiModelProperty("周末日均进站客流")
    private BigInteger weekend;//weekend_average
    @ApiModelProperty("整年日均进站客流")
    private BigInteger all;//all_average
    @ApiModelProperty("月份")
    private Integer month;//b_month
    @ApiModelProperty("日期")
    private Integer date;//b_month
}
