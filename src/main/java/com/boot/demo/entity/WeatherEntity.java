package com.boot.demo.entity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigInteger;
//CWZ
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class WeatherEntity {
    /*
    输入参数
     */
    private Integer year;

    /*
    天气属性
     */
    private String weather;

    /*
    客流值
     */
    private BigInteger flow;

    /*
    以下是折线图的横坐标
     */
    private Integer month;

    /*
    以下是柱状图的横坐标以及单线路的传入参数
     */
    private String line;

}
