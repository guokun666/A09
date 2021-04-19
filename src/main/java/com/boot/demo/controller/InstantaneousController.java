package com.boot.demo.controller;

import com.boot.demo.components.common.base.BaseResult;
import com.boot.demo.entity.InstantaneousEntity;
import com.boot.demo.service.InstantaneousService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author CWZ
 * @date 2021-4-14
 */
@Slf4j
@RestController
@RequestMapping("historyData/instantaneous")
@Api(tags = "历史数据")
public class InstantaneousController {

    @Autowired
    private InstantaneousService instantaneousService;

    @ApiOperation(value = "单线路-瞬时分析",
            notes = "2020-4-17\n" +
                    "只有单线路有瞬时分析，一共三个数据[只实现前两个]:\n" +
                    "全天的各瞬时段客流\n" +
                    "全年的各瞬时段客流\n" +
                    "客流峰值瞬时段（前3个高和低时段）[没有做]"
    )
    @GetMapping("/singleLine")
    public Object getByYear(@RequestParam("time") String time, @RequestParam("station") String station){
        //return InstantaneousService.getInstantaneousFlowByYear(station);
        return BaseResult.ok(instantaneousService.getDayFlowByDayAndStation(time,station));

    }

}
