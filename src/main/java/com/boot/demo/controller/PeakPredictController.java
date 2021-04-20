package com.boot.demo.controller;

import com.boot.demo.components.common.base.BaseResult;
import com.boot.demo.entity.PeakPredictEntity;
import com.boot.demo.service.PeakPredictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.boot.demo.components.common.constant.CommonConstants.*;

@Slf4j
@RestController
@RequestMapping("/predictData/peak")
@Api(tags = "预测数据")
public class PeakPredictController {

    @Autowired
    private PeakPredictService peakPredictService;



    @GetMapping("/morning")
    @ApiOperation(value = "城市-城市早晚高峰客流预测", notes = "根据选的单选框显示各个线路的不同预测高峰的客流\n" +
            "0是早高峰，1是晚高峰，2是整体\n")
    public Object getCityTime(@RequestParam("time") Integer time) {
        List<PeakPredictEntity>entities=peakPredictService.getCityTime(time+"");

        PAUSE();

        String[] GROUP={"进站","出站"};

        List<List<Integer>>data=CREATE_LISTS(GROUP.length,LINE_NUMBERS,0);

        for(PeakPredictEntity e:entities){
            Integer index=INDEX_OF_STRINGS(LINE_NAME,e.getLine());
            data.get(0).set(index,e.getFlow_in());
            data.get(1).set(index,e.getFlow_out());
        }

        return BaseResult.ok(CHART_JSON(LINE_NAME,SERIES_LIST(GROUP,"bar",data)));
    }
//    @GetMapping("/topLine")
//    @ApiOperation(value = "预测城市早晚高峰客流的最值", notes = "根据选的单选框展示最大值得线路和客流以及聚集度\n郭某人注释")
//    public Object getPeak(@RequestParam("time") String time) {
//        return peakPredictService.getPeak(time);
//    }




}

