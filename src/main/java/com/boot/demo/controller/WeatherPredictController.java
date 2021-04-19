package com.boot.demo.controller;

import com.boot.demo.service.WeatherPredictService;
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
@RequestMapping("/futruedata/weather")
@Api(tags = "A09")
public class WeatherPredictController {

    @Autowired
    private WeatherPredictService weatherPredictService;



    @GetMapping("/")
    @ApiOperation(value = "预测天气展示", notes = "根据选的单选框天气，1=星期天，2=星期一, ……7=星期六，需要注意一下\n郭某人注释")
    public Object getWeather(@RequestParam("day") String day){
        return weatherPredictService.getWeather(day);
    }



}

