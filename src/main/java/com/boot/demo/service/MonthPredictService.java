package com.boot.demo.service;


import com.boot.demo.entity.MonthPredictEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MonthPredictService {
    public List<MonthPredictEntity> getCityMonth();
    public List<MonthPredictEntity> getCityTop();
    public List<MonthPredictEntity> getStationMonth(Integer y_month);
    public List<MonthPredictEntity> getStationSum(Integer y_day, String line, String station_name);
    public List<MonthPredictEntity> getStationTime(Integer y_day, String line, String station_name);
    public List<MonthPredictEntity> getStationTop(Integer y_day, String line);

}
