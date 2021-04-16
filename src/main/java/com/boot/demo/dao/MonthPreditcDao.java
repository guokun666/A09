package com.boot.demo.dao;

import com.boot.demo.entity.MonthPreditcEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface MonthPreditcDao {

    List<MonthPreditcEntity> getCityMonth();
    List<MonthPreditcEntity> getCityTopMax();
    List<MonthPreditcEntity> getCityTopMin();
    List<MonthPreditcEntity> getStationMonth(@Param("month")Integer month);
    List<MonthPreditcEntity> getStationSum(@Param("date")Integer date,@Param("singleline")String singleline,@Param("station")
                                            String station);
    List<MonthPreditcEntity> getStationTime(@Param("date")Integer date,@Param("singleline")String singleline,@Param("station")
            String station);
    List<MonthPreditcEntity> getStationTopIn(@Param("date")Integer date,@Param("singleline")String singleline);
    List<MonthPreditcEntity> getStationTopOut(@Param("date")Integer date,@Param("singleline")String singleline);

}

