package com.boot.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigInteger;

/**
 * @author guokun
 * @email 317557750@qq.com
 * @date 2021-4-8 09:41:07
 * @Des 使用@Data注解就不用写GetSet方法了，Lombok会自动生成，对象.set()和对象.get()能直接使用
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel("历史：用户年龄结果表 d")
public class UserAgeEntity {

    @ApiModelProperty("用户进出站年份")
    private Integer year;

    @ApiModelProperty("站点名称")
    private String stationName;

    @ApiModelProperty("线路名称")
    private String lineName;

    @ApiModelProperty("青少年人数")
    private BigInteger youth;

    @ApiModelProperty("中青年人数")
    private BigInteger midYouth;

    @ApiModelProperty("中年人数")
    private BigInteger middleAge;

    @ApiModelProperty("老年人数")
    private BigInteger old;

}
