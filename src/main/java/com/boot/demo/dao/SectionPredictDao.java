package com.boot.demo.dao;

import com.boot.demo.entity.SectionPredictEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface SectionPredictDao {


    List<SectionPredictEntity> getSectionList(@Param("time")String time, @Param("singleline")String line, @Param("day")Integer day);
    SectionPredictEntity getTopUp(@Param("time")String time, @Param("singleline")String line, @Param("day")Integer day);
    SectionPredictEntity getTopDown(@Param("time")String time, @Param("singleline")String line, @Param("day")Integer day);
}

