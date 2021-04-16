package com.boot.demo.dao;

import com.boot.demo.entity.PeakEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PeakDao {

   List<PeakEntity> getCityPeak(@Param("year") Integer year);//实体里的字段名字
   List<PeakEntity> getCityPercentage(@Param("year") Integer year);
   List<PeakEntity> getLinePeak(@Param("year") Integer year,@Param("singleline")String singleline);//实体里的字段名字
   List<PeakEntity> getLinePercentage(@Param("year") Integer year,@Param("singleline")String singleline);
   List<PeakEntity> getLineMonthPeak(@Param("year") Integer year,@Param("singleline")String singleline,@Param("month")Integer month);//实体里的字段名字
   List<PeakEntity> getLineMonthPercentage(@Param("year") Integer year,@Param("singleline")String singleline,@Param("month")Integer month);
}

