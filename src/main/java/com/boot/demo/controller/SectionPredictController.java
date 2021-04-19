package com.boot.demo.controller;

import com.boot.demo.service.SectionPredictService;
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
@RequestMapping("/futruedata/preditc")
@Api(tags = "A09")
public class SectionPredictController {

    @Autowired
    private SectionPredictService sectionpreditcService;


    @GetMapping("/section")
    @ApiOperation(value = "展示预测单线路断面", notes = "选择范围展示断面图和预警")
    public Object getSection(@RequestParam("time") String time,@RequestParam("line") String line,@RequestParam("day")Integer day) {
        return sectionpreditcService.getSection(time,line,day);
    }




}

