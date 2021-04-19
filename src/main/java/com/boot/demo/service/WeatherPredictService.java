package com.boot.demo.service;


import com.boot.demo.entity.WeatherPredictEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WeatherPredictService {//数据库的字段
    public List<WeatherPredictEntity> getWeather(String w_day);

}
