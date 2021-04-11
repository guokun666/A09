package com.boot.demo.service;

import com.boot.demo.entity.StationEntity;
import org.springframework.stereotype.Service;

/**
 * @author guokun
 */
@Service
public interface StationService {
    /*根据站点id查询站点信息*/
    public StationEntity getByStationId(String id);

}

