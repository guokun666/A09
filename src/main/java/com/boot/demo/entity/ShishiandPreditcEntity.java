package com.boot.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude
        (JsonInclude.Include.NON_NULL)
@Data
@ApiModel("实时客流和预测客流客流结果表实体类s")
public class ShishiandPreditcEntity {//s
    @ApiModelProperty("线路")
    private String line;//line
    @ApiModelProperty("进站客流")
    private Integer flow_in;//flow_in
    @ApiModelProperty("出站客流")
    private String flow_out;//flow_out
    @ApiModelProperty("时间")
    private String time;//
}
