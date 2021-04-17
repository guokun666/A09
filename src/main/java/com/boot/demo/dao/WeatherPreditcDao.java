package com.boot.demo.dao;

import com.boot.demo.entity.WeatherPreditcEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface WeatherPreditcDao {

   List<WeatherPreditcEntity> getWeatherOne(@Param("day") String day);//实体里的字段名字
   List<WeatherPreditcEntity> getWeatherTwo(@Param("day") String day);
   List<WeatherPreditcEntity> getWeatherThree(@Param("day")String day);
}

