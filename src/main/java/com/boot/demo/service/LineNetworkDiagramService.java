package com.boot.demo.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CWZ
 */
@Service
public interface LineNetworkDiagramService {
    /*
    城市线网
     */
    List<JSONObject> getCityInformation();


    /*
    * 单线路线网*/
    List<JSONObject>getLineStationInformation(String line);

    List<JSONObject>getLineTrainInformation(String line);



}

