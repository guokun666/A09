package com.boot.demo.service.impl;

import com.boot.demo.dao.WorkdayDao;
import com.boot.demo.entity.WorkdayEntity;
import com.boot.demo.service.WorkdayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author guokun
        */
@Slf4j
@Service
public class WorkdayServiceImpl implements WorkdayService {
    @Autowired
    private WorkdayDao WorkdayDao;

    @Override
    public WorkdayEntity getYear(Integer b_year) {
        return WorkdayDao.getYear(b_year);
    }
    @Override
    public List<WorkdayEntity> getMonth(Integer b_year) {
        return WorkdayDao.getMonth(b_year);
    }
    @Override
    public List<WorkdayEntity> getLine(Integer b_year) {
        return WorkdayDao.getLine(b_year);
    }
    @Override
    public List<WorkdayEntity> getSingleyear(Integer b_year,String line) {
        return  WorkdayDao.getSingleyear(b_year,line);
    }
    @Override
    public List<WorkdayEntity> getSinglemonth(Integer b_year,String line) {
        return  WorkdayDao.getSinglemonth(b_year,line);
    }
}

