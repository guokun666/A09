package com.boot.demo.dao;

import com.boot.demo.entity.PeakPredictEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PeakPredictDao {

   List<PeakPredictEntity> getCityTime(@Param("time") String time);//实体里的字段名字
   PeakPredictEntity getPeakMoring(@Param("time") String time);//实体里的字段名字
   PeakPredictEntity getPeakEvening(@Param("time") String time);//实体里的字段名字
}

