package com.boot.demo.controller;

import com.boot.demo.service.MonthPreditcService;
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
@RequestMapping("/futuredata/preditc")
@Api(tags = "A09")
public class MonthPreditcController {

    @Autowired
     private MonthPreditcService monthpreditcService;

    @GetMapping("/")
    @ApiOperation(value = "根据预测各条线路一定时间内的客流",notes = "")
    public Object getCityMonth(){
        return monthpreditcService.getCityMonth();
//   ..../history/line/a_1?year=2020&line=1号线
        // ..../history/line/a_1/2020/1号线
    }
    @GetMapping("/stationpreditc")
    @ApiOperation(value = "根据预测各站点一定时间内的客流",notes = "")
    public Object getStationMonth(@RequestParam("month")Integer month){
        return monthpreditcService.getStationMonth(month);
//   ..../history/line/a_1?year=2020&line=1号线
        // ..../history/line/a_1/2020/1号线
    }
    @GetMapping("/preditctop")
    @ApiOperation(value = "根据预测显示最大和最小线路",notes = "")
    public Object getCityTop(){
        return monthpreditcService.getCityTop();
//   ..../history/line/a_1?year=2020&line=1号线
        // ..../history/line/a_1/2020/1号线
    }
    @GetMapping("/preditcstation")
    @ApiOperation(value = "根据预测显示单站点总和",notes = "")
    public Object getStationSum(@RequestParam("date")Integer date,@RequestParam("singleline")String singleline,@RequestParam("station")String station){
        return monthpreditcService.getStationSum(date,singleline,station);
//   ..../history/line/a_1?year=2020&line=1号线
        // ..../history/line/a_1/2020/1号线
    }
    @GetMapping("/stationtime")
    @ApiOperation(value = "根据预测显示单站点时间段客流",notes = "")
    public Object getStationTime(@RequestParam("date")Integer date,@RequestParam("singleline")String singleline,@RequestParam("station")String station){
        return monthpreditcService.getStationTime(date,singleline,station);
//   ..../history/line/a_1?year=2020&line=1号线
        // ..../history/line/a_1/2020/1号线
    }

}
