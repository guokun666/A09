package com.boot.demo.service.impl;

import com.boot.demo.dao.WeatherPredictDao;

import com.boot.demo.entity.WeatherPredictEntity;

import com.boot.demo.service.WeatherPredictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guokun
        */
@Slf4j
@Service
public class WeatherPredictServiceImpl implements WeatherPredictService {
    @Autowired
    private WeatherPredictDao weatherPredictDao;


    @Override
    public List<WeatherPredictEntity> getWeather(String w_day) {//数据库的字段名
        if (w_day == "1")
        {
            return weatherPredictDao.getWeatherOne(w_day);}
        else if (w_day == "2")
        {return weatherPredictDao.getWeatherTwo(w_day);}
        else {
            return weatherPredictDao.getWeatherThree(w_day);}
    }
}

