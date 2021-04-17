package com.boot.demo.controller;

import com.boot.demo.service.HolidayPreditcService;
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
public class HolidayPreditcController {

    @Autowired
     private HolidayPreditcService holidaypreditcService;

    @GetMapping("/cityholiday")
    @ApiOperation(value = "根据预测节假日客流客流",notes = "")
    public Object getCityHoliday(){
        return holidaypreditcService.getCityHoliday();
//   ..../history/line/a_1?year=2020&line=1号线
        // ..../history/line/a_1/2020/1号线
    }
    @GetMapping("/stationholiday")
    @ApiOperation(value = "根据预测节假日站点客流客流",notes = "")
    public Object getStationHoliday(){
        return holidaypreditcService.getStationHoliday();
//   ..../history/line/a_1?year=2020&line=1号线
        // ..../history/line/a_1/2020/1号线
    }


}
