package com.boot.demo.dao;

import com.boot.demo.entity.LineMonthEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface LineMonthDao {

    List<LineMonthEntity> getBYAyl(@Param("Year") Integer Year,@Param("Line") String Line);


}

