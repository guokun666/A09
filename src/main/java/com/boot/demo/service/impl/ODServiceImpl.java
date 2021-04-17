package com.boot.demo.service.impl;

import com.boot.demo.dao.ODDao;
import com.boot.demo.entity.ODEntity;
import com.boot.demo.service.ODService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guokun
        */
@Slf4j
@Service
public class ODServiceImpl implements ODService {
    @Autowired
    private ODDao odDao;

    @Override
    public List<ODEntity> getOD(String f_date,String line) {//数据库的字段名
        return odDao.getOD(f_date,line);
    }



}

