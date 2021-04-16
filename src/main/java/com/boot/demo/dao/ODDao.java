package com.boot.demo.dao;

import com.boot.demo.entity.ODEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ODDao {


    List<ODEntity> getOD(@Param("day")String day,@Param("line")String line);
}

