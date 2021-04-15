package com.boot.demo.service.impl;

import com.boot.demo.dao.LineMonthDao;
import com.boot.demo.entity.LineMonthEntity;
import com.boot.demo.service.LineMonthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author guokun
 */
@Slf4j
@Service
public class LineMonthServiceImpl implements LineMonthService {
    @Autowired
    private LineMonthDao lineMonthDao;

    @Override
    public List<LineMonthEntity> getBYAyl(Integer a_year, String line) {
        return lineMonthDao.getBYAyl(a_year,line);
    }
    @Override
    public List<LineMonthEntity> getByMonth(Integer a_year, String line,Integer a_month) {
        return lineMonthDao.getByMonth(a_year,line,a_month);
    }
    @Override
    public List<LineMonthEntity> getCitymonth(Integer a_year) {
        return lineMonthDao.getCitymonth(a_year);
    }
    @Override
    public List<LineMonthEntity> getCityline(Integer a_year,Integer a_month ) {
        return lineMonthDao.getCityline(a_year,a_month);
    }
    @Override
    public List<LineMonthEntity> getCitydate(Integer a_year,Integer a_month ) {
        return lineMonthDao.getCitydate(a_year,a_month);
    }

}

