package com.boot.demo.service;

import com.boot.demo.entity.FlowEventEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guokun
 */
@Service
public interface FlowEventService{
    List<FlowEventEntity> selectEventsByDay(String date);
    //根据ID修改is_done字段
    void setDoneOrNotDoneByID(Integer eventNo);
    void insertNewEvent(FlowEventEntity eventEntity);
}

