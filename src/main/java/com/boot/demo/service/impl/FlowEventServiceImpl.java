package com.boot.demo.service.impl;

import com.boot.demo.components.common.base.BaseResult;
import com.boot.demo.dao.FlowEventDao;
import com.boot.demo.entity.FlowEventEntity;
import com.boot.demo.service.FlowEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FlowEventServiceImpl implements FlowEventService {
    @Autowired
    private FlowEventDao flowEventDao;

    @Override
    public List<FlowEventEntity> selectEventsByDay(String date) {
        return flowEventDao.selectEventsByDay(date);
    }

    @Override
    public void setDoneOrNotDoneByID(Integer eventNo) {
        flowEventDao.setDoneOrNotDoneByID(eventNo);
    }

    @Override
    public void insertNewEvent(FlowEventEntity eventEntity) {
        flowEventDao.insertNewEvent(eventEntity);
    }
}
