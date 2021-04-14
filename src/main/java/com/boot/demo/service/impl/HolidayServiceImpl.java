package com.boot.demo.service.impl;

import com.boot.demo.dao.HolidayDao;
import com.boot.demo.entity.HolidayEntity;
import com.boot.demo.service.HolidayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author CWZ
 */
@Slf4j
@Service
public class HolidayServiceImpl implements HolidayService {
    @Autowired
    private HolidayDao HolidayDao;

    /*
    以下是城市
     */
    @Override
    public List<HolidayEntity> getFlowByYear(Integer year) { return HolidayDao.getFlowByYear(year); }

    @Override
    public List<HolidayEntity> getHolidayFlowByYear(Integer year) { return HolidayDao.getHolidayFlowByYear(year); }

    /*
    以下是单线路
     */
//    @Override
}

