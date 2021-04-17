package com.boot.demo.controller;

import com.boot.demo.service.InstantaneousService;
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
@RequestMapping("historydata/instantaneous")
@Api(tags = "A09")
public class InstantaneousController {

    @Autowired
    private InstantaneousService instantaneousService;

    @ApiOperation(value = "历史查询--单线路--瞬时分析",
            notes = "2020-4-14\n" +
                    "只有单线路有瞬时分析，一共两个接口:\n" +
                    "全天的各瞬时段客流\n" +
                    "全年的各瞬时段客流\n"
    )
    @GetMapping("/singleline")
    public Object getByYear(@RequestParam("year") String year, @RequestParam("line") String line){
        /*
        目前还只返回了单线路上下行
         */
        //return InstantaneousService.getInstantaneousFlowByYear(year);
        return instantaneousService.getDayFlowByDayAndStation(year, line);
    }

}
