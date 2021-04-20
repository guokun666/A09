package com.boot.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.components.common.base.BaseResult;
import com.boot.demo.dao.SectionPredictDao;
import com.boot.demo.entity.SectionEntity;
import com.boot.demo.entity.SectionPredictEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.boot.demo.components.common.constant.CommonConstants.*;
import static com.boot.demo.components.common.constant.CommonConstants.TWO_JSON;

@Slf4j
@RestController
@RequestMapping("/predictData/section")
@Api(tags = "预测数据")
public class SectionPredictController {

    @Autowired
    private SectionPredictDao sectionPredictDao;


    @GetMapping("/singleLine")
    @ApiOperation(value = "单线路-断面预测", notes = "选择范围展示断面图和预警\n" +
            "time 为时间段（高峰时间段 0早高峰 1晚高峰 2全日（可以传中文）")
    public Object getSection(@RequestParam("time") String time,
                             @RequestParam("lineID") Integer lineID,
                             @RequestParam("day")Integer day) {

        String[] TIME={"早高峰","晚高峰","全天"};
        if(time.equals("0")||time.equals("1")||time.equals("2"))time=TIME[Integer.parseInt(time)];

        String line = lineID+"号线";

        List<SectionPredictEntity> entities = sectionPredictDao.getSectionList(time,line,day);

        Integer lineIndex=INDEX_OF_STRINGS(LINE_NAME,line);

        List<List<Integer>>data=CREATE_LISTS(2,STATION_OF_LINES[lineIndex].length,0);

        for(SectionPredictEntity e:entities){
            Integer index=INDEX_OF_STRINGS(STATION_OF_LINES[lineIndex],e.getStation());
            data.get(0).set(index,e.getFlow_up());
            data.get(1).set(index,e.getFlow_down());
        }

        String[] NAME={"上行","下行"};

        List<Object>series=new ArrayList<>();
        for(int i=0;i<2;i++){
            series.add(SERIES_JSON(NAME[i],"bar",data.get(i)));
        }
        //1
        JSONObject barChart=CHART_JSON(STATION_OF_LINES[lineIndex],series);

        String[] peakTimeString={"07:00-9:00","17:00-19:00","07:00-9:00,17:00-19:00"};

        //2
        SectionPredictEntity up = sectionPredictDao.getTopUp(time,line,day);
        SectionPredictEntity down = sectionPredictDao.getTopDown(time,line,day);
        JSONObject cardChart=new JSONObject(true);
        if(up!=null&&down!=null)
            cardChart=TWO_JSON("peakTime",peakTimeString[INDEX_OF_STRINGS(TIME,time)],
                    "biggestSection",TWO_JSON("up",up.getStation(),
                            "down",down.getStation()));

        return BaseResult.ok(TWO_JSON("barChart",barChart,"cardChart",cardChart));

    }




}

