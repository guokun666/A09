package com.boot.demo.dao;

import com.boot.demo.entity.WeatherPredictEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface WeatherPredictDao {

   List<WeatherPredictEntity> getWeatherOne(@Param("day") String day);//实体里的字段名字
   List<WeatherPredictEntity> getWeatherTwo(@Param("day") String day);
   List<WeatherPredictEntity> getWeatherThree(@Param("day")String day);
}

