package com.boot.demo.entity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigInteger;

//CWZ
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class InstantaneousEntity {
    /*
    时间属性
     */
    private String time;

    /*
    站点属性
     */
    private String station;

    /*
    客流值
     */
    private BigInteger flow_in;

    private BigInteger flow_out;

}
