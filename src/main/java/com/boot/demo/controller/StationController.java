package com.boot.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.components.common.base.BaseResult;
import com.boot.demo.entity.StationEntity;
import com.boot.demo.service.StationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.boot.demo.components.common.constant.CommonConstants.LINE_NAME;
import static com.boot.demo.components.common.constant.CommonConstants.STRING_TO_INT;


/**
 * @author guokun
 * @email 317557750@qq.com
 * @date 2021-4-10
 */
@Slf4j
@RestController
@RequestMapping("/station")
@Api(tags = "基础数据")
public class StationController {

    @Autowired
    private StationService stationService;


    @ApiOperation("通过ID获取站点信息")
    @GetMapping("/{stationId}")
    public Object getByStationId(@PathVariable("stationId") String stationId){
        StationEntity station=stationService.getByStationId(stationId);
        return BaseResult.ok(station);
    }

    @GetMapping("/sort")
    @ApiOperation("获取各线路站点拓扑序列")
    public Object getStationSortOfLines(){
        List<StationEntity>stations=stationService.getAllStation();

        JSONObject json=new JSONObject(true);


        for(int i=0;i<8;i++){
            List<String>lineStation=new ArrayList<>();
            String line=LINE_NAME[i];
            for(StationEntity station:stations){
                if(station.getLineName().equals(line))
                    lineStation.add(station.getStationName());
            }

            json.put("line_"+STRING_TO_INT(line),lineStation);
        }

        return BaseResult.ok(json);
    }

}
