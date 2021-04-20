package com.boot.demo.controller;

import com.boot.demo.components.common.base.BaseResult;
import com.boot.demo.entity.HolidayPredictEntity;
import com.boot.demo.service.HolidayPredictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.boot.demo.components.common.constant.CommonConstants.*;

@Slf4j
@RestController
@RequestMapping("/predictData/holiday")
@Api(tags = "预测数据")
public class HolidayPredictController {

    @Autowired
     private HolidayPredictService holidayPredictService;

    @GetMapping("/city")
    @ApiOperation(value = "城市-节假日预测",notes = "2020-4-17\n" +
            "根据预测节假日客流客流\n" +
            "参数：yearNumber")
    public Object getCityHoliday(@RequestParam("yearNumber")Integer yearNumber){
        List<HolidayPredictEntity>entities = holidayPredictService.getCityHoliday();
        if(entities==null||yearNumber<0)return BaseResult.error();

        PAUSE();

        List<String>AXIS=new ArrayList<>();
        List<BigInteger>data=new ArrayList<>();

        for(HolidayPredictEntity e:entities){
            Integer index=INDEX_OF_LIST(AXIS,e.getHoliday());
            if(index==-1){
                AXIS.add(e.getHoliday());
                data.add(e.getFlow());
            }else data.set(index,e.getFlow());
        }

        return BaseResult.ok(CHART_JSON(AXIS.toArray(),data));
    }
//    @GetMapping("/station")
//    @ApiOperation(value = "根据预测节假日站点客流客流",notes = "")
//    public Object getStationHoliday(){
//        return holidayPredictService.getStationHoliday();
//    }


}
