package com.boot.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigInteger;

@JsonInclude
        (JsonInclude.Include.NON_NULL)
@Data
@ApiModel("单月客流预测表实体类y")
public class MonthPredictEntity {//y
    @ApiModelProperty("线路")
    private String singleline;//line
    @ApiModelProperty("进站客流量")
    private BigInteger flow_in;//flow_in
    @ApiModelProperty("出站客流量")
    private BigInteger flow_out;//flow_out
    @ApiModelProperty("预测月份范围")
    private Integer month;//y_month
    @ApiModelProperty("预测日期范围")
    private Integer date;//y_date
    @ApiModelProperty("站点名称")
    private String station;//station_name
    @ApiModelProperty("时间段")
    private String time;//time_slot


}
