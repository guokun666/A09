package com.boot.demo.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

/**
 * @author guokun
 */
@Service
public interface WorkdayService {

    public JSONObject getYear(Integer b_year);
public JSONObject getMonth(Integer b_year);
public JSONObject getLine(Integer b_year);
public JSONObject getSingleyear(Integer b_year, String line);
    public JSONObject getSinglemonth(Integer b_year, String line);
}

