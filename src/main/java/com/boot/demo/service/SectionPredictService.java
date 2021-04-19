package com.boot.demo.service;


import com.boot.demo.entity.SectionPredictEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SectionPredictService {//数据库的字段

    public List<SectionPredictEntity> getSection(String time_slot, String line, Integer y_day);
}
