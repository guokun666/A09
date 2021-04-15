package com.boot.demo.service.impl;

import com.boot.demo.dao.PeakDao;
import com.boot.demo.entity.PeakEntity;
import com.boot.demo.service.PeakService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author guokun
        */
@Slf4j
@Service
public class PeakServiceImpl implements PeakService {
    @Autowired
    private PeakDao peakDao;


    @Override
    public List<PeakEntity> getCity(Integer e_year) {//数据库的字段名
        List<PeakEntity> A=peakDao.getCityPeak(e_year);
        A.addAll(peakDao.getCityPercentage(e_year));
        return A;
    }
    @Override
    public List<PeakEntity> getLine(Integer e_year,String line) {//数据库的字段名
        List<PeakEntity> A=peakDao.getLinePeak(e_year,line);
        A.addAll(peakDao.getLinePercentage(e_year,line));
        return A;
    }
    @Override
    public List<PeakEntity> getLineMonth(Integer e_year,String line,Integer e_month) {//数据库的字段名
        List<PeakEntity> A=peakDao.getLineMonthPeak(e_year,line,e_month);
        A.addAll(peakDao.getLineMonthPercentage(e_year,line,e_month));
        return A;
    }

}

