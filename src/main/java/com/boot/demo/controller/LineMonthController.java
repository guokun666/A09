package com.boot.demo.controller;
import com.boot.demo.service.LineMonthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/line")
@Api(tags = "A09")
public class LineMonthController {

    @Autowired
     private LineMonthService lineMonthService;

    @GetMapping("/{Year}/{Line}")
    @ApiOperation(value = "根据年份和线路查询该线路每月客流",notes = "")
    public Object getBYAyl(@PathVariable("Year") Integer Ayear,@PathVariable("Line") String Line){
        return lineMonthService.getBYAyl(Ayear, Line);
    }

}
