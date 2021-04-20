package com.boot.demo.service;

import com.boot.demo.entity.StationRealTimeEntity;
import com.boot.demo.entity.TrainsRealTimeEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guokun
 */
@Service
public interface RealTimeService {
    List<StationRealTimeEntity> getSingleLineRealTimeStationFlow(String line,Long time);

    //获取站点即将入站的列车实时数据 线路名+时间戳
    List<TrainsRealTimeEntity> getSingleLineRealTimeTrainFlow(String line,Long time);

}

