package com.boot.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigInteger;

@JsonInclude
        (JsonInclude.Include.NON_NULL)
@Data
@ApiModel("单站点客流结果表实体类c")
public class StationflowEntity {//c
    @ApiModelProperty("年份")
    private Integer year;//c_year
    @ApiModelProperty("线路")
    private String singleline;//line
    @ApiModelProperty("进站流量")
    private Integer flow_in;//flow_in
    @ApiModelProperty("出站客流")
    private Integer flow_out;//flow_out
    @ApiModelProperty("站点名称")
    private String station;//station_name
    @ApiModelProperty("月份")
    private Integer month;//c_month
    @ApiModelProperty("日期")
    private Integer date;//c_date
    @ApiModelProperty("时间")
    private Integer time;//c_time
}
