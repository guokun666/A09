package com.boot.demo.dao;

import com.boot.demo.entity.MonthPredictEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface MonthPredictDao {

    List<MonthPredictEntity> getCityMonth();
    List<MonthPredictEntity> getCityTopMax();
    List<MonthPredictEntity> getCityTopMin();
    List<MonthPredictEntity> getStationMonth(@Param("month")Integer month);
    List<MonthPredictEntity> getStationSum(@Param("date")Integer date, @Param("singleline")String singleline, @Param("station")
                                            String station);
    List<MonthPredictEntity> getStationTime(@Param("date")Integer date, @Param("singleline")String singleline, @Param("station")
            String station);
    List<MonthPredictEntity> getStationTopIn(@Param("date")Integer date, @Param("singleline")String singleline);
    List<MonthPredictEntity> getStationTopOut(@Param("date")Integer date, @Param("singleline")String singleline);

}

