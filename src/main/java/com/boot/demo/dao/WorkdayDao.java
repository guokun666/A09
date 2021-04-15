package com.boot.demo.dao;

import com.boot.demo.entity.WorkdayEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface WorkdayDao {

    WorkdayEntity getYear(@Param("year") Integer year);
   List<WorkdayEntity> getMonth(@Param("year")Integer year);
   List<WorkdayEntity> getLine(@Param("year")Integer year);
   List<WorkdayEntity> getSingleyear(@Param("year")Integer year,@Param("singleline")String singleline);
    List<WorkdayEntity> getSinglemonth(@Param("year")Integer year,@Param("singleline")String singleline);

}

