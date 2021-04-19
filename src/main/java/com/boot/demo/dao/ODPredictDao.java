package com.boot.demo.dao;

import com.boot.demo.entity.ODPredictEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ODPredictDao {


    List<ODPredictEntity> getOD(@Param("day")Integer day, @Param("line")String line);
}

