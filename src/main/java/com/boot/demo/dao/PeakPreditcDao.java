package com.boot.demo.dao;

import com.boot.demo.entity.PeakPreditcEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PeakPreditcDao {

   List<PeakPreditcEntity> getCityTime(@Param("time") String time);//实体里的字段名字
   List<PeakPreditcEntity> getPeakMoring(@Param("time") String time);//实体里的字段名字
   List<PeakPreditcEntity> getPeakEvening(@Param("time") String time);//实体里的字段名字
}

