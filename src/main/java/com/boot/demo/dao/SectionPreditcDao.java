package com.boot.demo.dao;

import com.boot.demo.entity.SectionPreditcEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface SectionPreditcDao {


    List<SectionPreditcEntity> getSectionList(@Param("time")String time,@Param("singleline")String line,@Param("day")Integer day);
    List<SectionPreditcEntity> getTopUp(@Param("time")String time,@Param("singleline")String line,@Param("day")Integer day);
    List<SectionPreditcEntity> getTopDown(@Param("time")String time,@Param("singleline")String line,@Param("day")Integer day);
}

