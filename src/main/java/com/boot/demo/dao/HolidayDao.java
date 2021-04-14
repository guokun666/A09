package com.boot.demo.dao;


import com.boot.demo.entity.HolidayEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CWZ
 * @date 2021-4-14
 */
@Repository
public interface HolidayDao {

     /*
     不同节假日日均客流量总计
      */
     List<HolidayEntity> getFlowByYear(@Param("year") Integer year);

     /*
     各线路所有节假日日均客流量与工作日对比情况
      */
     List<HolidayEntity> getHolidayFlowByYear(@Param("year") Integer year);

     /*
     单线路--节假日高峰小时断面量（上行）
      */
     List<HolidayEntity> getDuanFLowByLine(@Param("year") Integer year, @Param("line") String line);
     /*
     单线路--节假日高峰小时断面量（下行）
      */
}
