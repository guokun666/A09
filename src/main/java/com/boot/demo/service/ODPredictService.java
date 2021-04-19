package com.boot.demo.service;


import com.boot.demo.entity.ODPredictEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ODPredictService {//数据库的字段
    public List<ODPredictEntity> getOD(Integer y_day, String line);
}
