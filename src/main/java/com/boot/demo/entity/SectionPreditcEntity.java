package com.boot.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude
        (JsonInclude.Include.NON_NULL)
@Data
@ApiModel("断面客流结果表实体类c")
public class SectionPreditcEntity {//g
    @ApiModelProperty("线路")
    private String line;//line
    @ApiModelProperty("上行流量")
    private Integer flow_up;//upward_flow
    @ApiModelProperty("下行客流")
    private Integer flow_down;//downword_flow
    @ApiModelProperty("站点名称")
    private String station;//station_name
    @ApiModelProperty("时间段")
    private String time;//time_slot
    @ApiModelProperty("预测范围")
    private String day;//y_day
}
