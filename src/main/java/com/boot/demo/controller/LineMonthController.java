package com.boot.demo.controller;
import com.boot.demo.service.LineMonthService;
import io.swagger.annotations.Api;
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
    public Object getBYAyl(@PathVariable("Year") Integer Ayear,@PathVariable("Line") String Line){
        return lineMonthService.getBYAyl(Ayear, Line);
    }

}
