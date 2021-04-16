package com.boot.demo.service.impl;

import com.boot.demo.dao.ODPreditcDao;

import com.boot.demo.entity.ODPreditcEntity;

import com.boot.demo.service.ODPreditcService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guokun
        */
@Slf4j
@Service
public class ODPreditcServiceImpl implements ODPreditcService {
    @Autowired
    private ODPreditcDao odpreditcDao;

    @Override
    public List<ODPreditcEntity> getOD(Integer y_day,String line) {//数据库的字段名
        return odpreditcDao.getOD(y_day,line);
    }



}

