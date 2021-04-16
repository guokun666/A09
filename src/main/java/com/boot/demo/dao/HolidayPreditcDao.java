package com.boot.demo.dao;

import com.boot.demo.entity.HolidayPreditcEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface HolidayPreditcDao {

    List<HolidayPreditcEntity> getCityHoliday();
    List<HolidayPreditcEntity> getStationHoliday();


}

