package com.boot.demo.service;

import com.boot.demo.entity.WeatherEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guokun
 */
@Service
public interface WeatherService {
    /*
    以下是历史查询--城市线网--天气
     */

    public List<WeatherEntity> getAllFlowByYear(Integer year);

    public List<WeatherEntity> getCardFlowByYear(Integer year);

    public List<WeatherEntity> getZheFlowByYear(Integer year);

    public List<WeatherEntity> getZhuFlowByYear(Integer year);

    /*
    以下是历史查询--单线路详情--天气
     */
    public List<WeatherEntity> getAllFlowByYearAndLine(Integer year, String line);

    public List<WeatherEntity> getCardFlowByYearAndLine(Integer year, String line);

    public List<WeatherEntity> getZheFlowByYearAndLine(Integer year, String line);
}

