package com.boot.demo.controller;
import com.boot.demo.service.LineMonthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/historydata/month")
@Api(tags = "A09")
public class LineMonthController {

    @Autowired
     private LineMonthService lineMonthService;

    @GetMapping("/singleline/year")
    @ApiOperation(value = "根据年份和线路查询该线路每月客流",notes = "")
    public Object getBYAyl(@RequestParam("year") Integer year, @RequestParam("singleline") String singleline){
        return lineMonthService.getBYAyl(year, singleline);
//   ..../history/line/a_1?year=2020&line=1号线
        // ..../history/line/a_1/2020/1号线
    }
    @GetMapping("/singleline/month")
    @ApiOperation(value = "根据年份,月份和线路查询该线路每月客流",notes = "")
    public Object getByMonth(@RequestParam("year") Integer year, @RequestParam("singleline") String singleline, @RequestParam("month") Integer month){
        return lineMonthService.getByMonth(year,singleline,month);
    }
    @GetMapping("/city/month_1")
    @ApiOperation(value = "根据年份查询城市各个月各个线路的客流",notes = "")
    public Object getCitymonth(@RequestParam("year") Integer year){
        return lineMonthService.getCitymonth(year);
    }
    @GetMapping("/city/month_2")
    @ApiOperation(value = "根据年份和月份查询城市各个线路的月客流",notes = "")
    public Object getCityline(@RequestParam("year") Integer year,@RequestParam("month")Integer month){
        return lineMonthService.getCityline(year,month);
    }
    @GetMapping("/city/month_3")
    @ApiOperation(value = "根据年份和月份查询城市各个线路的本月单天的客流",notes = "")
    public Object getCitydate(@RequestParam("year") Integer year,@RequestParam("month")Integer month){
        return lineMonthService.getCitydate(year,month);
    }
}
