package com.boot.demo.service;

import com.boot.demo.entity.WorkdayEntity;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author guokun
 */
@Service
public interface WorkdayService {

    public WorkdayEntity getYear(Integer b_year);
public List<WorkdayEntity> getMonth(Integer b_year);
public List<WorkdayEntity> getLine(Integer b_year);
public List<WorkdayEntity> getSingleyear(Integer b_year,String line);
    public List<WorkdayEntity> getSinglemonth(Integer b_year,String line);
}

