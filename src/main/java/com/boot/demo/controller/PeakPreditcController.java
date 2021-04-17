package com.boot.demo.controller;

import com.boot.demo.service.PeakPreditcService;
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
@RequestMapping("/futruedata/peak")
@Api(tags = "A09")
public class PeakPreditcController {

    @Autowired
    private PeakPreditcService peakpreditcService;



    @GetMapping("/mornjing")
    @ApiOperation(value = "预测城市早晚高峰客流", notes = "根据选的单选框显示各个线路的不同预测高峰的客流，1是早高，2是晚高\n郭某人注释")
    public Object getCityTime(@RequestParam("time") String time) {
        return peakpreditcService.getCityTime(time);
    }
    @GetMapping("/topline")
    @ApiOperation(value = "预测城市早晚高峰客流的最值", notes = "根据选的单选框展示最大值得线路和客流以及聚集度\n郭某人注释")
    public Object getPeak(@RequestParam("time") String time) {
        return peakpreditcService.getPeak(time);
    }




}

