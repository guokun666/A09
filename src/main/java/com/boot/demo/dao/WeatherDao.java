package com.boot.demo.dao;


import com.boot.demo.entity.WeatherEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CWZ
 * @date 2021-4-14
 */
@Repository
public interface WeatherDao {

     /*
     全年的日均客流
      */
     List<WeatherEntity> getAllFlowByYear(@Param("year") Integer year);

     /*
     全年各个天气的日均客流
      */
     List<WeatherEntity> getCardFlowByYear(@Param("year") Integer year);

     /*
     折线图
      */
     List<WeatherEntity> getZheFlowByYear(@Param("year") Integer year);

     /*
     柱状图
      */
     List<WeatherEntity> getZhuFlowByYear(@Param("year") Integer year);

     /*
     单线路--卡片客流，全年日均
      */
     List<WeatherEntity> getAllFlowByYearAndLine(@Param("year") Integer year, @Param("line") String line);

     /*
     单线路--卡片客流，各个天气
      */
     List<WeatherEntity> getCardFlowByYearAndLine(@Param("year") Integer year, @Param("line") String line);

     /*
     单线路--各月份日均客流量走势
      */
     List<WeatherEntity> getZheFlowByYearAndYear(@Param("year") Integer year, @Param("line") String line);
}
