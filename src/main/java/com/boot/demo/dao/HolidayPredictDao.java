package com.boot.demo.dao;

import com.boot.demo.entity.HolidayPredictEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HolidayPredictDao {

    List<HolidayPredictEntity> getCityHoliday();
    List<HolidayPredictEntity> getStationHoliday();


}

