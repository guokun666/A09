package com.boot.demo.service;


import com.alibaba.fastjson.JSONObject;
import com.boot.demo.entity.StationflowEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StationflowService {//数据库的字段
    public JSONObject getStationflow(Integer c_year, String line, String station_name);
    public List<StationflowEntity> getStationyear(Integer c_year, String line,String station_name);
    public List<StationflowEntity> getStationmonth(Integer c_year, String line,String station_name,Integer c_month);
    public List<StationflowEntity> getStationday(Integer c_year, String line,String station_name,Integer c_month,Integer c_date);
    public List<StationflowEntity> getTop(Integer c_year,String line);
}
