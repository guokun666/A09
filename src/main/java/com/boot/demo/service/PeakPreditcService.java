package com.boot.demo.service;


import com.boot.demo.entity.PeakPreditcEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PeakPreditcService {//数据库的字段
    public List<PeakPreditcEntity> getCityTime(String time_attribute);
    public List<PeakPreditcEntity> getPeak(String time_attribute);

}
