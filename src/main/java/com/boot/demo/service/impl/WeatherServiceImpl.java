package com.boot.demo.service.impl;

import com.boot.demo.dao.WeatherDao;
import com.boot.demo.entity.WeatherEntity;
import com.boot.demo.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author CWZ
 */
@Slf4j
@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    private WeatherDao weatherDao;

    /*
    以下是城市
     */
    @Override
    public List<WeatherEntity> getCardFlowByYear(Integer year) { return weatherDao.getCardFlowByYear(year); }

    @Override
    public List<WeatherEntity> getAllFlowByYear(Integer year) { return weatherDao.getAllFlowByYear(year); }

    @Override
    public List<WeatherEntity> getZheFlowByYear(Integer year) { return weatherDao.getZheFlowByYear(year); }

    @Override
    public List<WeatherEntity> getZhuFlowByYear(Integer year) { return weatherDao.getZhuFlowByYear(year); }

    /*
    以下是单线路
     */
    @Override
    public List<WeatherEntity> getAllFlowByYearAndLine(Integer year, String line) { return weatherDao.getAllFlowByYearAndLine(year, line); }

    @Override
    public List<WeatherEntity> getCardFlowByYearAndLine(Integer year, String line) { return weatherDao.getAllFlowByYearAndLine(year, line); }

    @Override
    public List<WeatherEntity> getZheFlowByYearAndLine(Integer year, String line) { return weatherDao.getAllFlowByYearAndLine(year, line); }
}

