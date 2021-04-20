package com.boot.demo.controller;

import com.boot.demo.service.ShishiandPreditcService;
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
public class ShishiandPreditcController {

    @Autowired
     private ShishiandPreditcService shishiandpreditcService;

    @GetMapping("/")
    @ApiOperation(value = "显示实时的客流变化",notes = "")
    public Object getCityFlow(@RequestParam("time")String time){
        return shishiandpreditcService.getCityFlow(time);
//   ..../history/line/a_1?year=2020&line=1号线
        // ..../history/line/a_1/2020/1号线
    }

}
