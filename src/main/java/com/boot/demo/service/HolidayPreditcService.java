package com.boot.demo.service;


import com.boot.demo.entity.HolidayPreditcEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HolidayPreditcService {
    public List<HolidayPreditcEntity> getCityHoliday();
    public List<HolidayPreditcEntity> getStationHoliday();


}
