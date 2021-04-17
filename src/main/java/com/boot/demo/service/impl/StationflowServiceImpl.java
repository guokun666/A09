package com.boot.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.dao.StationflowDao;
import com.boot.demo.entity.StationflowEntity;
import com.boot.demo.service.StationflowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.boot.demo.components.common.constant.CommonConstants.TWO_JSON;

/**
 * @author guokun
        */
@Slf4j
@Service
public class StationflowServiceImpl implements StationflowService {
    @Autowired
    private StationflowDao stationflowDao;

    @Override
    public JSONObject getStationflow(Integer c_year, String line, String station_name) {//数据库的字段名
        StationflowEntity entity=stationflowDao.getStationflow(c_year,line,station_name);
        if(entity==null)return null;
        return TWO_JSON("flowIn",entity.getFlow_in(),"flowOut",entity.getFlow_out());
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
    @Override
    public List<StationflowEntity> getTop(Integer c_year,String line) {//数据库的字段名
        List<StationflowEntity> b=stationflowDao.getTopIn(c_year,line);
        b.addAll(stationflowDao.getTopOut(c_year,line));
        return b;
    }

}

