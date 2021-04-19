package com.boot.demo.service;


import com.boot.demo.entity.PeakPredictEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PeakPredictService {//数据库的字段
    public List<PeakPredictEntity> getCityTime(String time_attribute);
    public PeakPredictEntity getPeak(String time_attribute);

}
