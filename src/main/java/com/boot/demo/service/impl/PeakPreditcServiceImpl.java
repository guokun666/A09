package com.boot.demo.service.impl;

import com.boot.demo.dao.PeakPreditcDao;
import com.boot.demo.entity.PeakPreditcEntity;
import com.boot.demo.service.PeakPreditcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guokun
        */
@Slf4j
@Service
public class PeakPreditcServiceImpl implements PeakPreditcService {
    @Autowired
    private PeakPreditcDao peakpreditcDao;


    @Override
    public List<PeakPreditcEntity> getCityTime(String time_attribute) {//数据库的字段名
       return peakpreditcDao.getCityTime(time_attribute);
    }
    @Override
    public List<PeakPreditcEntity> getPeak(String time_attribute) {//数据库的字段名
        if(time_attribute == "1")
      return peakpreditcDao.getPeakMoring(time_attribute);
       else
       return peakpreditcDao.getPeakEvening(time_attribute);
    }

}

