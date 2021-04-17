package com.boot.demo.service.impl;

import com.boot.demo.dao.InstantaneousDao;
import com.boot.demo.entity.InstantaneousEntity;
import com.boot.demo.service.InstantaneousService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author CWZ
 */
@Slf4j
@Service
public class InstantaneousServiceImpl implements InstantaneousService {
    @Autowired
    private InstantaneousDao InstantaneousDao;

    /*
    全天瞬时客流
     */

    public List<InstantaneousEntity> getDayFlowByDayAndStation(String time, String station)
    {
        return InstantaneousDao.getDayFlowByDayAndStation(time, station);
    }

    /*
    全年瞬时客流
     */

    public List<InstantaneousEntity> getYearFlowByYearAndStation(String year, String station)
    {
        return InstantaneousDao.getYearFlowByYearAndStation(year, station);
    }

}

