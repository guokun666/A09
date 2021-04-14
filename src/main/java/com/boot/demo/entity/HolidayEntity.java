package com.boot.demo.entity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigInteger;

//CWZ
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class HolidayEntity {
    /*
    年份属性
     */
    private Integer year;

    /*
    节假日属性
     */
    private String holiday;

    /*
    客流值
    (节假日日均客流以及工作日日均客流)
    (节假日上下行客流)
     */
    private BigInteger day_average;

    private BigInteger holiday_upflow;

    private BigInteger workday_upflow;

    private BigInteger holiday_downflow;

    private BigInteger workday_downflow;

    /*
    以下是折线图的横坐标
     */
    private Integer month;

    /*
    线路属性
     */
    private String line;

    /*
    站点属性
     */
    private String station;

}
