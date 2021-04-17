package com.boot.demo.controller;

import com.boot.demo.service.ODPreditcService;

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
@RequestMapping("/futuredata/preditc")
@Api(tags = "A09")
public class ODpreditcController {

    @Autowired
    private ODPreditcService odpreditcService;


    @GetMapping("/OD")
    @ApiOperation(value = "根据预测范围显示OD报表", notes = "如题")
    public Object getOD(@RequestParam("day") Integer day,@RequestParam("line")String line) {
        return odpreditcService.getOD(day,line);
    }




}

