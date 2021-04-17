package com.boot.demo.controller;

import com.boot.demo.service.ODService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/historyData/OD")
@Api(tags = "A09")
public class ODController {

    @Qualifier("ODServiceImpl")
    @Autowired
    private ODService odService;


    @GetMapping("/singleLine")
    @ApiOperation(value = "根据选择的日期显示OD报表", notes = "如题")
    public Object getOD(@RequestParam("day") String day,@RequestParam("line")String line) {
        return odService.getOD(day,line);
    }




}

