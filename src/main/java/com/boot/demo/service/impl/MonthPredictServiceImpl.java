package com.boot.demo.service.impl;

import com.boot.demo.dao.MonthPredictDao;
import com.boot.demo.entity.MonthPredictEntity;
import com.boot.demo.service.MonthPredictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author guokun
 */
@Slf4j
@Service
public class MonthPredictServiceImpl implements MonthPredictService {
    @Autowired
    private MonthPredictDao monthpreditcDao;

    @Override
    public List<MonthPredictEntity> getCityMonth() {
        return monthpreditcDao.getCityMonth();
    }
    @Override
    public List<MonthPredictEntity> getCityTop() {

        List<MonthPredictEntity> b=monthpreditcDao.getCityTopMax();
        b.addAll(monthpreditcDao.getCityTopMin());
        return b;
    }
    @Override
    public List<MonthPredictEntity> getStationMonth(Integer y_month) {
        return monthpreditcDao.getStationMonth(y_month);
    }
    @Override
    public List<MonthPredictEntity> getStationSum(Integer y_day, String line, String station_name) {
        return monthpreditcDao.getStationSum(y_day,line,station_name);
    }
    @Override
    public List<MonthPredictEntity> getStationTime(Integer y_day, String line, String station_name) {
        return monthpreditcDao.getStationTime(y_day,line,station_name);
    }
    @Override
    public List<MonthPredictEntity> getStationTop(Integer y_day, String line) {
       List<MonthPredictEntity> a=monthpreditcDao.getStationTopIn(y_day, line);
       a.addAll(monthpreditcDao.getStationTopIn(y_day, line));
       return a;
    }


}

