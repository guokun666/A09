package com.boot.demo.controller;

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
 * @author CWZ
 * @date 2021-4-14
 */
@Slf4j
@RestController
@RequestMapping("historydata/Holiday")
@Api(tags = "A09")
public class HolidayController {

    @Autowired
    private HolidayService HolidayService;

    @ApiOperation(value = "节假日分析（3个图的数据）",
            notes = "2020-4-14\n" +
                    "城市界面有2个接口需要转换:\n" +
                    "不同节假日日均客流量总计\n" +
                    "各线路所有节假日日均客流量与工作日对比情况\n" +
                    "单线路详情界面有1个接口（两个表整合成一个,姐姐写开了不知道是不是得写俩接口）\n" +
                    "节假日高峰小时断面量（上下行）\n" )
    @GetMapping("/singleline")
    public Object getByYear(@RequestParam("year") Integer year, @RequestParam("line") String line){
        /*
        目前还只返回了单线路上下行
         */
        //return HolidayService.getHolidayFlowByYear(year);
        return HolidayService.getDuanFLowByLine(year, line);
    }

}
