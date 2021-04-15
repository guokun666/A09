package com.boot.demo.entity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigInteger;
//CWZ
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class WeatherEntity {
    //晴天 1  阴天 2 雨天 3
    public final static String[] WeatherString={
        "天气属性：晴天（1）,阴天（2）,雨天（3）",
            "晴天", "阴天", "雨天"
    };


    public static String weatherIDtoString(Integer weatherID){
      if(weatherID>=1&&weatherID<=WeatherString.length)return WeatherString[weatherID];
      else return null;
    };

    public static Integer weatherStringToID(String weather){
        for(int i=1;i<WeatherString.length;i++){
            if(weather==WeatherString[i])return i;
        }
        return null;
    }

    /*
    输入参数
     */
    private Integer year;

    /*
    天气属性
     */
    private Integer weather;

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
