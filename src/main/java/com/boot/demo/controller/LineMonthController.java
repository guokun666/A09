package com.boot.demo.controller;
import com.alibaba.fastjson.JSONObject;
import com.boot.demo.components.common.base.BaseResult;
import com.boot.demo.service.LineMonthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/historyData/month")
@Api(tags = "历史数据")
public class LineMonthController {

    @Autowired
     private LineMonthService lineMonthService;

    @GetMapping("/singleLine/year")
    @ApiOperation(value = "单线路-年度客流查询",notes = "2020-4-16\n根据年份和线路查询该线路每月客流")
    public Object getBYAyl(@RequestParam("year") Integer year, @RequestParam("lineID") String lineID){
        return BaseResult.ok(lineMonthService.getBYAyl(year, lineID+"号线"));
    }
    @GetMapping("/singleLine/month")
    @ApiOperation(value = "单线路-月度客流查询",notes = "2020-4-16\n根据年份,月份和线路查询该线路每月客流")
    public Object getByMonth(@RequestParam("year") Integer year, @RequestParam("lineID") String lineID, @RequestParam("month") Integer month){
        return BaseResult.ok(lineMonthService.getByMonth(year,lineID+"号线",month));
    }
    @GetMapping("/city/year")
    @ApiOperation(value = "单线路-单月整体客流分析",
            notes = "2020-4-16\n" +
                    "参数只有一个 year\n" +
                    "返回该年每个月各个线路的客流信息")
    public Object getCitymonth(@RequestParam("year") Integer year){
        return BaseResult.ok(lineMonthService.getCitymonth(year));
    }
    @GetMapping("/city/month")
    @ApiOperation(value = "城市-各线客流（柱状图和折线图）",
            notes = "2020-4-16\n" +
                    "根据年份和月份查询城市各个线路的月客流以及每日客流\n" +
                    "返回的数据包含两个图的 barChart,lineChart")
    public Object getCityline(@RequestParam("year") Integer year,@RequestParam("month")Integer month){
        JSONObject data=new JSONObject(true);
        data.put("barChart",lineMonthService.getCityline(year,month));
        data.put("lineChart",lineMonthService.getCitydate(year,month));
        return BaseResult.ok(data);
    }
}
