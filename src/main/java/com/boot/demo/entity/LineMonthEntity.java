package com.boot.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@Data

public class LineMonthEntity {
    private Integer Year;//a_year
    private String Line;//line
    private BigInteger Flow;//flow
    private Integer Month;//a_month
}
