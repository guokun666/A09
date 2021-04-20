package com.boot.demo.dao;

import com.boot.demo.entity.ShishiandPreditcEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ShishiandPreditcDao {

    List<ShishiandPreditcEntity> getCityFlow(@Param("time") String time);
    List<ShishiandPreditcEntity> getLineFlow(@Param("time") String time,@Param("line")String line);


}

