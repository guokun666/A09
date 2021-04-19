package com.boot.demo.controller;

import com.boot.demo.components.common.base.BaseResult;
import com.boot.demo.entity.MonthPredictEntity;
import com.boot.demo.service.MonthPredictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static com.boot.demo.components.common.constant.CommonConstants.*;

@Slf4j
@RestController
@RequestMapping("/predictData/singleMonth")
@Api(tags = "预测数据")
public class MonthPredictController {

    @Autowired
     private MonthPredictService monthPredictService;

    @GetMapping("/city")
    @ApiOperation(value = "城市-单月预测-各线路客流预测量",notes = "根据预测各条线路一定时间内的客流")
    public Object getCityMonth(@RequestParam("monthNumber")Integer monthNumber){
        List<MonthPredictEntity> entities = monthPredictService.getCityMonth();
        if(entities==null||monthNumber<0||monthNumber>3)return BaseResult.error();

        PAUSE(500);

        String[] AXIS=ADD_TO_STRING("未来",INIT_FROM_A_TO_B(1,monthNumber),"月");

        List<List<BigInteger>>data=CREATE_LISTS(LINE_NUMBERS,monthNumber,BigInteger.ZERO);

        for(MonthPredictEntity e:entities){
            if(e.getMonth()<=monthNumber)
                data.get(INDEX_OF_STRINGS(LINE_NAME,e.getSingleline()+"号线")).set(e.getMonth()-1,e.getFlow_in());
        }

        return BaseResult.ok(
                CHART_JSON(AXIS,SERIES_LIST(
                        LINE_NAME,"bar",data
                ))
        );
    }
//    @GetMapping("/stationpreditc")
//    @ApiOperation(value = "根据预测各站点一定时间内的客流",notes = "")
//    public Object getStationMonth(@RequestParam("month")Integer month){
//        List<MonthPredictEntity> entities = monthPredictService.getStationMonth(month);
//        return null;
//    }
//    @GetMapping("/preditctop")
//    @ApiOperation(value = "根据预测显示最大和最小线路",notes = "")
//    public Object getCityTop(){
//        return monthPredictService.getCityTop();
////   ..../history/line/a_1?year=2020&line=1号线
//        // ..../history/line/a_1/2020/1号线
//    }
//    @GetMapping("/preditcstation")
//    @ApiOperation(value = "根据预测显示单站点总和",notes = "")
//    public Object getStationSum(@RequestParam("date")Integer date,@RequestParam("singleline")String singleline,@RequestParam("station")String station){
//        return monthPredictService.getStationSum(date,singleline,station);
////   ..../history/line/a_1?year=2020&line=1号线
//        // ..../history/line/a_1/2020/1号线
//    }
//    @GetMapping("/stationtime")
//    @ApiOperation(value = "根据预测显示单站点时间段客流",notes = "")
//    public Object getStationTime(@RequestParam("date")Integer date,@RequestParam("singleline")String singleline,@RequestParam("station")String station){
//        return monthPredictService.getStationTime(date,singleline,station);
////   ..../history/line/a_1?year=2020&line=1号线
//        // ..../history/line/a_1/2020/1号线
//    }

}
