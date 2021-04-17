package com.boot.demo.service;


import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface PeakService {//数据库的字段
    public JSONObject getCity(Integer e_year);
    public JSONObject getLine(Integer e_year, String line);
    public JSONObject getLineMonth(Integer e_year, String line, Integer e_month);
}
