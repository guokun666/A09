package com.boot.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigInteger;

/**
 * @author A09团队
 * @email 317557750@qq.com
 * @date 2021-4-8 09:41:07
 * @Des 使用@Data注解就不用写GetSet方法了，Lombok会自动生成，对象.set()和对象.get()能直接使用
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StationEntity {

    /**
     * 主键
     */
    private BigInteger stationId;//id

    /**
     * 站点名称
     */
    private String stationName;//station_name

    /**
     * 所在线路名
     */
    private String lineName;//line_name

    /**
     * 区域
     */
    private String districtName;//district

    /**
     * 序列号
     */
    private BigInteger sequenceNumber;//sequence


}
