package com.boot.demo.controller;
import com.boot.demo.service.LineMonthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/history/line")
@Api(tags = "A09")
public class LineMonthController {

    @Autowired
     private LineMonthService lineMonthService;

    @GetMapping("/a_1")
    @ApiOperation(value = "根据年份和线路查询该线路每月客流",notes = "")
    public Object getBYAyl(@RequestParam("Year") Integer Year, @RequestParam("Line") String Line){
        return lineMonthService.getBYAyl(Year, Line);
//   ..../history/line/a_1?year=2020&line=1号线
        // ..../history/line/a_1/2020/1号线
    }

}
