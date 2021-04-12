package com.boot.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.dao.LineNetworkDiagramDao;
import com.boot.demo.entity.LineNetworkDiagramEntity;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * @author guokun
 * @email 317557750@qq.com
 * @date 2021-4-10
 */
@Slf4j
@ResponseBody
@RestController
@RequestMapping("/LineNetworkDiagram")
@Api(tags = "A09")
public class LineNetworkDiagramController {

    @Autowired
    private LineNetworkDiagramDao lineNetworkDiagramDao;

    /**
     * restful风格接口，get请求在后面拼接url地址
     * @return
     */

    @GetMapping("/")
    public Object getByStationName(){
        List<LineNetworkDiagramEntity> stations = lineNetworkDiagramDao.getStationInformation();
        List<JSONObject> jsons = new ArrayList<JSONObject>();
        for(LineNetworkDiagramEntity station:stations){
            jsons.add(station.getStationJson());
        }
        return jsons;

//        LineNetworkDiagramEntity entity =new LineNetworkDiagramEntity();
//        String s=entity.getStationJson().toString();
//        entity.setLineTitleInformation("一号线",1,1,"#000");
//        s+=entity.getLineTitleJson().toString();
//        entity.setTrainInformation(8,2,0,"Sta1",2000);
//        s+=entity.getTrainJson().toString();
//        return s;
    }
}
