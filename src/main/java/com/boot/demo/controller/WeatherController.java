package com.boot.demo.controller;

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
@Api(tags = "A09")
public class WeatherController {

    @Autowired
    private WeatherService WeatherService;

    @ApiOperation(value = "城市线网界面--天气分析（3个图的数据）",
            notes = "2020-4-14\n" +
                    "城市界面有4个接口需要转换:\n" +
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
        /*
        目前还只返回了全年日均客流卡片数据
         */
        //return WeatherService.getAllFlowByYear(year);
        return WeatherService.getCardFlowByYear(year);
        //return WeatherService.getZheFlowByYear(year);
        //return WeatherService.getZhuFlowByYear(year);
    }

}
