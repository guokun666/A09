package com.boot.demo.dao;

import com.boot.demo.entity.LineMonthEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface LineMonthDao {

    List<LineMonthEntity> getBYAyl(@Param("year") Integer year,@Param("singleline") String singleline);

List<LineMonthEntity> getByMonth(@Param("year") Integer year,@Param("singleline") String singleline,@Param("month") Integer month);
    List<LineMonthEntity> getCitymonth(@Param("year") Integer year);
    List<LineMonthEntity> getCityline(@Param("year") Integer year,@Param("month")Integer month);
    List<LineMonthEntity> getCitydate(@Param("year")Integer year,@Param("month")Integer month);
}

