package com.boot.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude
        (JsonInclude.Include.NON_NULL)
@Data
@ApiModel("早高峰预测客流结果表实体类y")
public class WeatherPredictEntity {//y
    @ApiModelProperty("预测时间")
    private String day;//w_day
    @ApiModelProperty("天气")
    private Integer weather;//flow
    @ApiModelProperty("最高温度")
    private String highesttemperature;//
    @ApiModelProperty("最低温度")
    private String lowesttemperature;//
    @ApiModelProperty("日期")
    private String date;//date
    @ApiModelProperty("星期")
    private String week;//week
}
