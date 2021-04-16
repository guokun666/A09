package com.boot.demo.controller;

import com.boot.demo.service.SectionService;
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
@RequestMapping("/historydata/station")
@Api(tags = "A09")
public class SectionController {

    @Autowired
    private SectionService sectionService;


    @GetMapping("/section")
    @ApiOperation(value = "单线路-展示线路断面", notes = "")
    public Object getSection(@RequestParam("time") String time,@RequestParam("singleline") String singleline) {
        return sectionService.getSection(time,singleline);
    }




}

