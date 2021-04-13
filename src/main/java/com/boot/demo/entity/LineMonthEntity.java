package com.boot.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@Data
@ApiModel("单月客流结果表实体类")
public class LineMonthEntity {
    @ApiModelProperty("查询的年份")
    private Integer Year;//a_year
    @ApiModelProperty("查询的线路")
    private String Line;//line
    @ApiModelProperty("返回的客流量")
    private BigInteger Flow;//flow
    @ApiModelProperty("返回的月份")
    private Integer Month;//a_month
}
