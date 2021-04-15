package com.boot.demo.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author guokun
 */
@Service
public interface WeatherService {
    /*
    以下是历史查询--城市线网--天气
     */

    public BigInteger getAllFlowByYear(Integer year);

    public List<Object> getCardFlowByYear(Integer year);

    public JSONObject getZheFlowByYear(Integer year);

    public JSONObject getZhuFlowByYear(Integer year);

    /*
    以下是历史查询--单线路详情--天气
     */
    public BigInteger getAllFlowByYearAndLine(Integer year, String line);

    public List<Object> getCardFlowByYearAndLine(Integer year, String line);

    public JSONObject getZheFlowByYearAndLine(Integer year, String line);
}

