package com.boot.demo.service;


import com.boot.demo.entity.WeatherPreditcEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WeatherPreditcService {//数据库的字段
    public List<WeatherPreditcEntity> getWeather(String w_day);

}
