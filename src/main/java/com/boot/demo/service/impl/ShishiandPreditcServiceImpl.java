package com.boot.demo.service.impl;


import com.boot.demo.dao.ShishiandPreditcDao;
import com.boot.demo.entity.ShishiandPreditcEntity;

import com.boot.demo.service.ShishiandPreditcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guokun
        */
@Slf4j
@Service
public class ShishiandPreditcServiceImpl implements ShishiandPreditcService {
    @Autowired
    private ShishiandPreditcDao shishiandpreditcDao;


    @Override
    public List<ShishiandPreditcEntity> getCityFlow(String time_stemp) {//数据库的字段名
       return shishiandpreditcDao.getCityFlow(time_stemp);
    }
    @Override
    public List<ShishiandPreditcEntity> getLineFlow(String time_stemp) {//数据库的字段名
        return shishiandpreditcDao.getCityFlow(time_stemp);
    }


}

