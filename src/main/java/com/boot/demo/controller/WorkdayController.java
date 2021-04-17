package com.boot.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.components.common.base.BaseResult;
import com.boot.demo.entity.WorkdayEntity;
import com.boot.demo.service.WorkdayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/historyData/workdayAndWeekend")
@Api(tags = "历史数据")
public class WorkdayController {

    @Autowired
    private WorkdayService workdayService;


    @GetMapping("/city")
    @ApiOperation(value = "城市-工作日与周末分析",
            notes = "2020-4-16\n" +
                    "根据年份查询城市工作日和周末以及全年总日均客流\n" +
                    "根据年份查询城市每月工作日和周末日均客流\n" +
                    "根据年份查询城市每条线路本年工作日和周末日均客流")
    public Object getYear(@RequestParam("year") Integer year) {
        JSONObject data=new JSONObject(true);
        data.put("cardChart",workdayService.getYear(year));
        data.put("lineChart",workdayService.getMonth(year));
        data.put("barChart",workdayService.getLine(year));
        return BaseResult.ok(data);
    }

    @GetMapping("/singleLine")
    @ApiOperation(value = "城市-工作日与周末分析"
            , notes = "2020-4-16\n" +
            "根据年份查询单线路本年工作日和周末日均客流" +
            "根据年份查询单线路每月工作日和周末日均客流")
    public Object getSingleyear(@RequestParam("year") Integer year,@RequestParam("lineID")String lineID) {
        JSONObject data=new JSONObject(true);
        String line=lineID+"号线";
        data.put("cardChart",workdayService.getSingleyear(year,line));
        data.put("lineChart",workdayService.getSinglemonth(year,line));
        return BaseResult.ok(data);
    }

}

