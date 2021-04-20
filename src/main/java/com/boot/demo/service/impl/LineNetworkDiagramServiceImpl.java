package com.boot.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.dao.LineNetworkDiagramDao;
import com.boot.demo.entity.LineNetworkDiagramEntity;
import com.boot.demo.service.LineNetworkDiagramService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author CWZ
 */
@Slf4j
@Service
public class LineNetworkDiagramServiceImpl implements LineNetworkDiagramService {
    @Autowired
    private LineNetworkDiagramDao lineNetworkDiagramDao;


    @Override
    public List<JSONObject> getCityInformation() {
        List<JSONObject>jsons=new ArrayList<>();
        //先获取 线路标题信息
        List<LineNetworkDiagramEntity> lineTitles = lineNetworkDiagramDao.getLineTitleInformation();
        //转换成json串
        for(LineNetworkDiagramEntity lineTitle:lineTitles){
            jsons.add(lineTitle.getLineTitleJson());
        }

        //再获取 站点信息
        List<LineNetworkDiagramEntity> stations = lineNetworkDiagramDao.getStationInformation();
        //转换成json串
        for(LineNetworkDiagramEntity station:stations){
            jsons.add(station.getStationJson());
        }

        return jsons;
    }

    @Override
    public List<JSONObject> getLineStationInformation(String line) {
        List<LineNetworkDiagramEntity>entities=lineNetworkDiagramDao.getSingleLineStationInformation(line);
        if(entities==null)return null;

        List<JSONObject>jsons=new ArrayList<>();

        for(LineNetworkDiagramEntity e:entities){

            jsons.add(e.getStationJson());
        }

        return jsons;
    }

    @Override
    public List<JSONObject> getLineTrainInformation(String line) {
        List<LineNetworkDiagramEntity>entities=lineNetworkDiagramDao.getSingleLineTrainInformation(line);
        if(entities==null)return null;

        List<JSONObject>jsons=new ArrayList<>();

        for(LineNetworkDiagramEntity e:entities){
            jsons.add(e.getTrainJson());
        }

        return jsons;
    }
}

