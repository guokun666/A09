package com.boot.demo.service.impl;

import com.boot.demo.dao.StationDao;
import com.boot.demo.entity.StationEntity;
import com.boot.demo.service.StationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author guokun
        */
@Slf4j
@Service
public class StationServiceImpl implements StationService {
    @Autowired
    private StationDao stationDao;

    @Override
    public StationEntity getByStationId(String id) {
        return stationDao.getByStationId(id);
    }

    @Override
    public List<StationEntity> getAllStation() {
        return stationDao.getAllStation();
    }


}

