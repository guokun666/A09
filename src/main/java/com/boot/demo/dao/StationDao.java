package com.boot.demo.dao;


import com.boot.demo.entity.StationEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author A09团队
 * @email 317557750@qq.com
 * @date 2021-4-8 09:41:07
 */
@Repository
public interface StationDao {



    /**
     * 通过ID查询站点名称
     * @param stationId
     * @return
     */
    StationEntity getByStationId(@Param("stationId") String stationId);

}
