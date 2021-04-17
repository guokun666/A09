package com.boot.demo.service.impl;

import com.boot.demo.dao.WeatherPreditcDao;

import com.boot.demo.entity.WeatherPreditcEntity;

import com.boot.demo.service.WeatherPreditcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guokun
        */
@Slf4j
@Service
public class WeatherPreditcServiceImpl implements WeatherPreditcService {
    @Autowired
    private WeatherPreditcDao weatherpreditcDao;


    @Override
    public List<WeatherPreditcEntity> getWeather(String w_day) {//数据库的字段名
        if (w_day == "1")
        {
            return weatherpreditcDao.getWeatherOne(w_day);}
        else if (w_day == "2")
        {return weatherpreditcDao.getWeatherTwo(w_day);}
        else {
            return weatherpreditcDao.getWeatherThree(w_day);}
    }
}

