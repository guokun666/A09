package com.boot.demo.service;


import com.boot.demo.entity.PeakEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PeakService {//数据库的字段
    public List<PeakEntity> getCity(Integer e_year);
    public List<PeakEntity> getLine(Integer e_year,String line);
    public List<PeakEntity> getLineMonth(Integer e_year,String line,Integer e_month);
}
