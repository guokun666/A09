package com.boot.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.entity.InstantaneousEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CWZ
 */
@Service
public interface InstantaneousService {
    /*
    全天瞬时客流
     */

    public JSONObject getDayFlowByDayAndStation(String time, String station);

    /*
    全年瞬时客流
     */

    public List<InstantaneousEntity> getYearFlowByYearAndStation(String station);


}

