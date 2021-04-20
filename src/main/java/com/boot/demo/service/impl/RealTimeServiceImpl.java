package com.boot.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.dao.RealTimeDao;
import com.boot.demo.dao.WorkdayDao;
import com.boot.demo.entity.*;
import com.boot.demo.service.RealTimeService;
import com.boot.demo.service.WorkdayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

import static com.boot.demo.components.common.constant.CommonConstants.*;


/**
 * @author guokun
        */
@Slf4j
@Service
public class RealTimeServiceImpl implements RealTimeService {
    @Autowired
    private RealTimeDao realTimeDao;


    @Override
    public List<StationRealTimeEntity> getSingleLineRealTimeStationFlow(String line, Long time) {
        return realTimeDao.getSingleLineRealTimeStationFlow(line,time);
    }

    @Override
    public List<TrainsRealTimeEntity> getSingleLineRealTimeTrainFlow(String line, Long time) {
        return realTimeDao.getSingleLineRealTimeTrainFlow(line,time);
    }

    @Override
    public List<FlowEntity> getCityRealTimeFlow(Long time) {
        return realTimeDao.getCityRealTimeFlow(time);
    }

    @Override
    public List<TrainOnlineBarEntity> getTrainOnlineBar() {
        return realTimeDao.getCityRealTimeTrain();
    }
}

