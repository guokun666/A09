package com.boot.demo.dao;


import com.boot.demo.entity.InstantaneousEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CWZ
 * @date 2021-4-14
 */
@Repository
public interface InstantaneousDao {

     /*
     全天15min瞬时客流折线图
      */
     List<InstantaneousEntity> getDayFlowByDayAndStation(@Param("day") String day, @Param("station") String station);

     /*
     全年15min瞬时客流折线图
      */
     List<InstantaneousEntity> getYearFlowByYearAndStation(@Param("year") String year, @Param("station") String station);

     /*
     客流峰值瞬时段
      */
     //List<InstantaneousEntity> getTopTimeByYearAndFlow(@Param("year") Integer year);

}
