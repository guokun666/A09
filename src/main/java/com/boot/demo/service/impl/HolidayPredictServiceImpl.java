package com.boot.demo.service.impl;

import com.boot.demo.dao.HolidayPredictDao;
import com.boot.demo.entity.HolidayPredictEntity;
import com.boot.demo.service.HolidayPredictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author guokun
 */
@Slf4j
@Service
public class HolidayPredictServiceImpl implements HolidayPredictService {
    @Autowired
    private HolidayPredictDao holidaypreditcDao;

    @Override
    public List<HolidayPredictEntity> getCityHoliday() {
        return holidaypreditcDao.getCityHoliday();
    }
    @Override
    public List<HolidayPredictEntity> getStationHoliday() {
        return holidaypreditcDao.getStationHoliday();
    }

}

