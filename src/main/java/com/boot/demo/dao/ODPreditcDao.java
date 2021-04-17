package com.boot.demo.dao;

import com.boot.demo.entity.ODPreditcEntity;
import com.boot.demo.entity.StationflowEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ODPreditcDao {


    List<ODPreditcEntity> getOD(@Param("day")Integer day,@Param("line")String line);
}

