package com.boot.demo.controller;

import com.boot.demo.service.WorkdayService;
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
@RequestMapping("/historydata/weekend")
@Api(tags = "A09")
public class WorkdayController {

    @Autowired
    private WorkdayService WorkdayService;


    @GetMapping("/city/day_average")
    @ApiOperation(value = "根据年份查询城市工作日和周末以及全年总日均客流", notes = "")
    public Object getYear(@RequestParam("year") Integer year) {
        return WorkdayService.getYear(year);
    }

    @GetMapping("/city/month_average")
    @ApiOperation(value = "根据年份查询城市每月工作日和周末日均客流", notes = "")
    public Object getMonth(@RequestParam("year") Integer year) {
        return WorkdayService.getMonth(year);
    }
    @GetMapping("/city/line_average")
    @ApiOperation(value = "根据年份查询城市每条线路本年工作日和周末日均客流", notes = "")
    public Object getLine(@RequestParam("year") Integer year) {
        return WorkdayService.getLine(year);
    }
    @GetMapping("/singleline/year")
    @ApiOperation(value = "根据年份查询单线路本年工作日和周末日均客流", notes = "")
    public Object getSingleyear(@RequestParam("year") Integer year,@RequestParam("singleline")String singleline) {
        return WorkdayService.getSingleyear(year,singleline);
    }
    @GetMapping("/singleline/month")
    @ApiOperation(value = "根据年份查询单线路每月工作日和周末日均客流", notes = "")
    public Object getSinglemonth(@RequestParam("year") Integer year,@RequestParam("singleline")String singleline) {
        return WorkdayService.getSinglemonth(year,singleline);
    }

}

