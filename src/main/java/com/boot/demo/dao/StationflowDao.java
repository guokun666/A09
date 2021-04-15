package com.boot.demo.dao;

import com.boot.demo.entity.StationflowEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface StationflowDao {

    StationflowEntity getStationflow(@Param("year") Integer year,@Param("singleline") String singleline,
                                           @Param("station")String station);//实体里的字段名字
    List<StationflowEntity> getStationyear(@Param("year")Integer year,@Param("singleline")String singleline,
                                           @Param("station")String station_name);
    List<StationflowEntity> getStationmonth(@Param("year")Integer year,@Param("singleline")String singleline,
                                           @Param("station")String station_name,@Param("month") Integer month);
    List<StationflowEntity> getStationIn(@Param("year")Integer year,@Param("singleline")String singleline,
                                            @Param("station")String station_name,@Param("month") Integer month
            ,@Param("date")Integer date);

    List<StationflowEntity> getStationOut(@Param("year")Integer year,@Param("singleline")String singleline,
                                          @Param("station")String station_name,@Param("month") Integer month
            ,@Param("date")Integer date);
}

