package com.boot.demo.dao;

import com.boot.demo.entity.FlowEntity;
import com.boot.demo.entity.StationRealTimeEntity;
import com.boot.demo.entity.TrainOnlineBarEntity;
import com.boot.demo.entity.TrainsRealTimeEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface RealTimeDao {
    //获取站点实时数据 线路名+时间戳
    List<StationRealTimeEntity> getSingleLineRealTimeStationFlow(@Param("line")String line,@Param("time")Long time);
    //获取站点即将入站的列车实时数据 线路名+时间戳
    List<TrainsRealTimeEntity> getSingleLineRealTimeTrainFlow(@Param("line")String line, @Param("time")Long time);

    /*--------------------------------------城市------------------------------------------*/
    //各线路实时客流
    List<FlowEntity>getCityRealTimeFlow(@Param("time")Long time);
    //实时列车信息
    List<TrainOnlineBarEntity>getCityRealTimeTrain();
}

