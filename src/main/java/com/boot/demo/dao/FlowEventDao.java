package com.boot.demo.dao;

import com.boot.demo.entity.FlowEventEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowEventDao {
    //获取date日期所有的突发事件信息（时间顺序排序）
    List<FlowEventEntity> selectEventsByDay(@Param("date")String date);
    //date日期和line列名获取所有该线路的突发事件信息（时间顺序排序）
    //根据ID修改is_done字段
    void setDoneOrNotDoneByID(@Param("eventNo")Integer eventNo);
    //插入新的突发事件
    void insertNewEvent(FlowEventEntity entity);
}
