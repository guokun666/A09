package com.boot.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigInteger;

@JsonInclude
        (JsonInclude.Include.NON_NULL)
@Data
@ApiModel("节假日客流预测表实体类y")
public class HolidayPreditcEntity {//y
    @ApiModelProperty("客流量")
    private BigInteger flow;//
    @ApiModelProperty("站点名称")
    private String station;//station_name
    @ApiModelProperty("节假日")
    private String holiday;//date_attribute


}
