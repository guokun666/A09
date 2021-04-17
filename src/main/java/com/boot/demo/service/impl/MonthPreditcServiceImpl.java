package com.boot.demo.service.impl;

import com.boot.demo.dao.MonthPreditcDao;
import com.boot.demo.entity.MonthPreditcEntity;
import com.boot.demo.service.MonthPreditcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author guokun
 */
@Slf4j
@Service
public class MonthPreditcServiceImpl implements MonthPreditcService {
    @Autowired
    private MonthPreditcDao monthpreditcDao;

    @Override
    public List<MonthPreditcEntity> getCityMonth() {
        return monthpreditcDao.getCityMonth();
    }
    @Override
    public List<MonthPreditcEntity> getCityTop() {

        List<MonthPreditcEntity> b=monthpreditcDao.getCityTopMax();
        b.addAll(monthpreditcDao.getCityTopMin());
        return b;
    }
    @Override
    public List<MonthPreditcEntity> getStationMonth(Integer y_month) {
        return monthpreditcDao.getStationMonth(y_month);
    }
    @Override
    public List<MonthPreditcEntity> getStationSum(Integer y_day,String line,String station_name) {
        return monthpreditcDao.getStationSum(y_day,line,station_name);
    }
    @Override
    public List<MonthPreditcEntity> getStationTime(Integer y_day,String line,String station_name) {
        return monthpreditcDao.getStationTime(y_day,line,station_name);
    }
    @Override
    public List<MonthPreditcEntity> getStationTop(Integer y_day,String line) {
       List<MonthPreditcEntity> a=monthpreditcDao.getStationTopIn(y_day, line);
       a.addAll(monthpreditcDao.getStationTopIn(y_day, line));
       return a;
    }


}

