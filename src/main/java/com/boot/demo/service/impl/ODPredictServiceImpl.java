package com.boot.demo.service.impl;

import com.boot.demo.dao.ODPredictDao;

import com.boot.demo.entity.ODPredictEntity;

import com.boot.demo.service.ODPredictService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guokun
        */
@Slf4j
@Service
public class ODPredictServiceImpl implements ODPredictService {
    @Autowired
    private ODPredictDao odpreditcDao;

    @Override
    public List<ODPredictEntity> getOD(Integer y_day, String line) {//数据库的字段名
        return odpreditcDao.getOD(y_day,line);
    }



}

