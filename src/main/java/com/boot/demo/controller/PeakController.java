package com.boot.demo.controller;

import com.boot.demo.service.PeakService;
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
@RequestMapping("/historydata/peak")
@Api(tags = "A09")
public class PeakController {

    @Autowired
    private PeakService peakService;



    @GetMapping("/year")
    @ApiOperation(value = "根据年份查询城市早高峰客流", notes = "")
    public Object getCity(@RequestParam("year") Integer year) {
        return peakService.getCity(year);
    }


    @GetMapping("/singleline/year")
    @ApiOperation(value = "根据年份查询单线路早高峰客流", notes = "")
    public Object getLine(@RequestParam("year") Integer year,@RequestParam("singleline")String singleline) {
        return peakService.getLine(year,singleline);
    }
    @GetMapping("/singleline/month")
    @ApiOperation(value = "根据年份和月份查询单线路早高峰客流", notes = "")
    public Object getLineMonth(@RequestParam("year") Integer year,@RequestParam("singleline")String singleline,
                               @RequestParam("month")Integer month) {
        return peakService.getLineMonth(year,singleline,month);
    }


}

