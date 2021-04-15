package com.boot.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.components.common.base.BaseResult;
import com.boot.demo.components.common.constant.CommonConstants;
import com.boot.demo.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author CWZ
 * @date 2021-4-14
 */
@Slf4j
@RestController
@RequestMapping("historydata/weather")
@Api(tags = "历史数据")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @ApiOperation(value = "城市-天气",
            notes = "2020-4-15\n" +
                    "城市界面有4天气个接口需要转换:\n" +
                    "全年日均客流\n" +
                    "全年各天气日均客流\n" +
                    "2020年天气--各月份日均流量走势折线图(字段名格式必须一致)\n" +
                    "2020年天气--各线路日均流量走势集合柱状图(字段名格式必须一致)\n" +
                    "单线路界面有3个接口需要转换\n" +
                    "单线路全年日均客流\n" +
                    "单线路各天气日均客流\n" +
                    "单线路各月份日均客流量走势(字段名格式必须一致)\n")
    @GetMapping("/city")
    public Object getByYear(@RequestParam("year") Integer year){
        JSONObject json = new JSONObject(true);

        json.put("allAverageFlow",weatherService.getAllFlowByYear(year));
        json.put("cardChart",weatherService.getCardFlowByYear(year));
        json.put("lineChart",weatherService.getZheFlowByYear(year));
        json.put("barChart",weatherService.getZhuFlowByYear(year));

        return BaseResult.ok(json);
    }

    @ApiOperation(value = "单线路-天气",
            notes = "2020-4-15\n" +
                    "三个单线路天气接口\n")
    @GetMapping("/signal_line")
    public Object getByYear(@RequestParam("year") Integer year,@RequestParam("lineID") Integer lineID){
        JSONObject json = new JSONObject(true);

        String line= lineID+"号线";

        json.put("allAverageFlow",weatherService.getAllFlowByYearAndLine(year,line));
        json.put("cardChart",weatherService.getCardFlowByYearAndLine(year,line));
        json.put("lineChart",weatherService.getZheFlowByYearAndLine(year,line));

        return BaseResult.ok(json);
    }

}
