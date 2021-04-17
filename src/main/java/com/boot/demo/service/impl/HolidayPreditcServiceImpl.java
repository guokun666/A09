package com.boot.demo.service.impl;

import com.boot.demo.dao.HolidayPreditcDao;
import com.boot.demo.entity.HolidayPreditcEntity;
import com.boot.demo.service.HolidayPreditcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author guokun
 */
@Slf4j
@Service
public class HolidayPreditcServiceImpl implements HolidayPreditcService {
    @Autowired
    private HolidayPreditcDao holidaypreditcDao;

    @Override
    public List<HolidayPreditcEntity> getCityHoliday() {
        return holidaypreditcDao.getCityHoliday();
    }
    @Override
    public List<HolidayPreditcEntity> getStationHoliday() {
        return holidaypreditcDao.getStationHoliday();
    }

}

