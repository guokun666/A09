package com.boot.demo.service;

import com.boot.demo.entity.StationEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guokun
 */
@Service
public interface StationService {
    /*根据站点id查询站点信息*/
    public StationEntity getByStationId(String id);

    //获取所有站点信息[order by 线路名,序列号]
    public List<StationEntity> getAllStation();
}

