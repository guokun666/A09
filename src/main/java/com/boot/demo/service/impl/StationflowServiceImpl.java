package com.boot.demo.service.impl;

import com.boot.demo.dao.StationflowDao;
import com.boot.demo.entity.StationflowEntity;
import com.boot.demo.service.StationflowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guokun
        */
@Slf4j
@Service
public class StationflowServiceImpl implements StationflowService {
    @Autowired
    private StationflowDao stationflowDao;

    @Override
    public StationflowEntity getStationflow(Integer c_year,String line,String station_name) {//数据库的字段名
        return stationflowDao.getStationflow(c_year,line,station_name);
    }
    @Override
    public List<StationflowEntity> getStationyear(Integer c_year,String line,String station_name) {//数据库的字段名
        return stationflowDao.getStationyear(c_year,line,station_name);
    }
    @Override
    public List<StationflowEntity> getStationmonth(Integer c_year,String line,String station_name,Integer c_month) {//数据库的字段名
        return stationflowDao.getStationmonth(c_year,line,station_name,c_month);
    }
    @Override
    public List<StationflowEntity> getStationday(Integer c_year,String line,String station_name,Integer c_month,Integer c_date) {//数据库的字段名
        List<StationflowEntity> A=stationflowDao.getStationIn(c_year,line,station_name,c_month,c_date);
        A.addAll(stationflowDao.getStationOut(c_year,line,station_name,c_month,c_date));
        return A;
    }

}

