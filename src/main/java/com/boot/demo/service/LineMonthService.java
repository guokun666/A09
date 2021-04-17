package com.boot.demo.service;


import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface LineMonthService {
    public JSONObject getBYAyl(Integer a_year, String line);
    public JSONObject getByMonth(Integer a_year, String line, Integer a_month);
public JSONObject getCitymonth(Integer a_year);
public JSONObject getCityline(Integer a_year, Integer a_month);
    public JSONObject getCitydate(Integer a_year, Integer a_month);
}
