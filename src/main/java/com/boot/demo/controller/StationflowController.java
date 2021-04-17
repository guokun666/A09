package com.boot.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.components.common.base.BaseResult;
import com.boot.demo.entity.StationflowEntity;
import com.boot.demo.service.StationflowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.boot.demo.components.common.constant.CommonConstants.TWO_JSON_LIST;

@Slf4j
@RestController
@RequestMapping("/historyData/stationFlow/singleLine")
@Api(tags = "A09")
public class StationflowController {

    @Autowired
    private StationflowService stationflowService;

    public static final String[] NAME={"入站","出站"};


    @GetMapping("/station")
    @ApiOperation(value = "根据年份和线路查询站点进出站客流", notes = "")
    public Object getStationflow(@RequestParam("year") Integer year,
                                 @RequestParam("lineID") String lineID,
                                 @RequestParam("station")String station) {
        JSONObject a =stationflowService.getStationflow(year,lineID+"号线",station);
        return BaseResult.ok(a);
    }
    @GetMapping("/station/year")
    @ApiOperation(value = "根据年份和线路查询站点的每月进出站客流", notes = "")
    public Object getStationyear(@RequestParam("year") Integer year,@RequestParam("lineID") String lineID,
                                 @RequestParam("station")String station) {
        return stationflowService.getStationyear(year,lineID+"号线",station);
    }
    @GetMapping("/station/month")
    @ApiOperation(value = "根据年份和线路,月份查询站点的每天进出站客流", notes = "")
    public Object getStationmonth(@RequestParam("year") Integer year,@RequestParam("lineID") String lineID,
                                 @RequestParam("station")String station,@RequestParam("month")Integer month) {
        return stationflowService.getStationmonth(year,lineID+"号线",station,month);
    }
    @GetMapping("/station/day")
    @ApiOperation(value = "根据年份和线路,月份以及日期查询站点的每天进出站客流", notes = "")
    public Object getStationday(@RequestParam("year") Integer year,@RequestParam("lineID") String lineID,
                                  @RequestParam("station")String station,@RequestParam("month")Integer month,
                                  @RequestParam("date")Integer date) {
        return stationflowService.getStationday(year,lineID+"号线",station,month,date);
    }
    @GetMapping("top")
    @ApiOperation(value = "单线路-进出站客流前三",
            notes = "由年份,线路获取(如果该线路站点总数少于三个会有bug！当然一般不会出现这种情况)")
    public Object getTop(@RequestParam("year") Integer year,@RequestParam("lineID")String lineID) {
        List<StationflowEntity>entities = stationflowService.getTop(year,lineID+"号线");
        List<String>name=new ArrayList<>();
        List<Integer>flow=new ArrayList<>();

        for(StationflowEntity e:entities){
            name.add(e.getStation());
            if(e.getFlow_in()==null)
                flow.add(e.getFlow_out());
            else
                flow.add(e.getFlow_in());
        }

        return BaseResult.ok(
                TWO_JSON_LIST("flowInTop3",
                        TWO_JSON_LIST("name",name.subList(0,3),"flow",flow.subList(0,3)),
                        "flowOutTop3",
                        TWO_JSON_LIST("name",name.subList(3,6),"flow",flow.subList(3,6))
                )
        );
    }



}

