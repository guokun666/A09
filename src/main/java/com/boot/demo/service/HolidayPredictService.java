package com.boot.demo.service;


import com.boot.demo.entity.HolidayPredictEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HolidayPredictService {
    public List<HolidayPredictEntity> getCityHoliday();
    public List<HolidayPredictEntity> getStationHoliday();


}
