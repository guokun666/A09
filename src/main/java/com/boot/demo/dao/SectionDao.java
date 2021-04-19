package com.boot.demo.dao;

import com.boot.demo.entity.SectionEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface SectionDao {


    List<SectionEntity> getSectionList(@Param("time")String time,@Param("singleline")String singleline);
    SectionEntity getTopUp(@Param("time")String time,@Param("singleline")String singleline);
    SectionEntity getTopDown(@Param("time")String time,@Param("singleline")String singleline);
}

