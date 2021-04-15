package com.boot.demo.service;


import com.boot.demo.entity.LineMonthEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LineMonthService {
    public List<LineMonthEntity> getBYAyl(Integer a_year, String line);
    public List<LineMonthEntity> getByMonth(Integer a_year, String line,Integer a_month);
public List<LineMonthEntity> getCitymonth(Integer a_year);
public List<LineMonthEntity> getCityline(Integer a_year,Integer a_month);
    public List<LineMonthEntity> getCitydate(Integer a_year,Integer a_month);
}
