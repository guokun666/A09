package com.boot.demo.entity;

import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.math.BigInteger;
@JsonInclude
        (JsonInclude.Include.NON_NULL)
@Data
@ApiModel("单月客流结果表实体类a")
public class LineMonthEntity {//a
    @ApiModelProperty("年份")
    private Integer year;//a_year
    @ApiModelProperty("线路")
    private String singleline;//line
    @ApiModelProperty("客流量")
    private BigInteger flow;
    @ApiModelProperty("月份")
    private Integer month;//a_month
    @ApiModelProperty("日期")
    private Integer date;//a_date
}
