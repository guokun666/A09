package com.boot.demo.controller;

import com.boot.demo.service.StationflowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/historydata")
@Api(tags = "A09")
public class StationflowController {

    @Autowired
    private StationflowService StationflowService;


    @GetMapping("/station")
    @ApiOperation(value = "根据年份和线路查询站点进出站客流", notes = "")
    public Object getStationflow(@RequestParam("year") Integer year,@RequestParam("singleline") String singleline,
                                 @RequestParam("station")String station) {
        return StationflowService.getStationflow(year,singleline,station);
    }
    @GetMapping("/station/year")
    @ApiOperation(value = "根据年份和线路查询站点的每月进出站客流", notes = "")
    public Object getStationyear(@RequestParam("year") Integer year,@RequestParam("singleline") String singleline,
                                 @RequestParam("station")String station) {
        return StationflowService.getStationyear(year,singleline,station);
    }
    @GetMapping("/station/month")
    @ApiOperation(value = "根据年份和线路,月份查询站点的每天进出站客流", notes = "")
    public Object getStationmonth(@RequestParam("year") Integer year,@RequestParam("singleline") String singleline,
                                 @RequestParam("station")String station,@RequestParam("month")Integer month) {
        return StationflowService.getStationmonth(year,singleline,station,month);
    }
    @GetMapping("/station/day")
    @ApiOperation(value = "根据年份和线路,月份以及日期查询站点的每天进出站客流", notes = "")
    public Object getStationday(@RequestParam("year") Integer year,@RequestParam("singleline") String singleline,
                                  @RequestParam("station")String station,@RequestParam("month")Integer month,
                                  @RequestParam("date")Integer date) {
        return StationflowService.getStationday(year,singleline,station,month,date);
    }



}

