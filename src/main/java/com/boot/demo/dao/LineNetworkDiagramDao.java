package com.boot.demo.dao;


import com.boot.demo.entity.LineNetworkDiagramEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author A09团队
 * @email 317557750@qq.com
 * @date 2021-4-11
 */
@Repository
public interface LineNetworkDiagramDao {

    List<LineNetworkDiagramEntity> getStationInformation();

}
