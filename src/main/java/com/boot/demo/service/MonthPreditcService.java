package com.boot.demo.service;


import com.boot.demo.entity.MonthPreditcEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MonthPreditcService {
    public List<MonthPreditcEntity> getCityMonth();
    public List<MonthPreditcEntity> getCityTop();
    public List<MonthPreditcEntity> getStationMonth(Integer y_month);
    public List<MonthPreditcEntity> getStationSum(Integer y_day,String line,String station_name);
    public List<MonthPreditcEntity> getStationTime(Integer y_day,String line,String station_name);
    public List<MonthPreditcEntity> getStationTop(Integer y_day,String line);

}
