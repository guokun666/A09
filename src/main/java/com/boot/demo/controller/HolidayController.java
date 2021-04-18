package com.boot.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.components.common.base.BaseResult;
import com.boot.demo.service.HolidayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author guokun
 * @date 2021-4-15
 */
@Slf4j
@RestController
@RequestMapping("historydata/holiday")
@Api(tags = "历史数据")
public class HolidayController {

    @Autowired
    private HolidayService holidayService;

    @ApiOperation(value = "城市-节假日分析",
            notes = "2020-4-15\n" +
                    "城市界面有2个接口需要转换:\n" +
                    "不同节假日日均客流量总计\n" +
                    "各线路所有节假日日均客流量与工作日对比情况\n" )
    @GetMapping("/city")
    public Object getByYear(@RequestParam("year") Integer year){
        JSONObject json=new JSONObject(true);
        json.put("differentHolidays",holidayService.getFlowByYear(year));
        json.put("holidayAndWorkday",holidayService.getAllLineHolidayAndWorkdayFlowByYear(year));
        return BaseResult.ok(json);
    }

    @ApiOperation(value = "单线路-节假日分析",
            notes = "2020-4-15\n" +
                    "单线路详情界面有1个接口（两个表整合成一个,姐姐写开了不知道是不是得写俩接口）\n" +
                    "节假日高峰小时断面量（上下行）\n" )
    @GetMapping("/signal_line")

    public Object getByYear(@RequestParam("year") Integer year, @RequestParam("lineID") Integer lineID){
        String line=lineID+"号线";
        return BaseResult.ok(holidayService.getDuanFLowByLine(year, line));
    }

}