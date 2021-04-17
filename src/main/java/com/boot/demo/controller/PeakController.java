package com.boot.demo.controller;

import com.boot.demo.components.common.base.BaseResult;
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
@RequestMapping("/historyData/peak")
@Api(tags = "历史数据")
public class PeakController {

    @Autowired
    private PeakService peakService;



    @GetMapping("/city")
    @ApiOperation(value = "城市-高峰客流", notes = "根据年份查询城市高峰客流")
    public Object getCity(@RequestParam("year") Integer year) {
        return BaseResult.ok(peakService.getCity(year));
    }


    @GetMapping("/singleLine/year")
    @ApiOperation(value = "单线路-高峰客流[年]", notes = "根据年份查询单线路高峰客流")
    public Object getLine(@RequestParam("year") Integer year,@RequestParam("lineID")String lineID) {
        return BaseResult.ok(peakService.getLine(year,lineID+"号线"));
    }
    @GetMapping("/singleLine/month")
    @ApiOperation(value = "单线路-高峰客流[月]", notes = "根据年份和月份查询单线路高峰客流")
    public Object getLineMonth(@RequestParam("year") Integer year,@RequestParam("lineID")String lineID,
                               @RequestParam("month")Integer month) {
        return BaseResult.ok(peakService.getLineMonth(year,lineID+"号线",month));
    }


}

