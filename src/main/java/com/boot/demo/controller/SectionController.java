package com.boot.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.components.common.base.BaseResult;
import com.boot.demo.dao.SectionDao;
import com.boot.demo.entity.SectionEntity;
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

@Slf4j
@RestController
@RequestMapping("/historyData/section")
@Api(tags = "历史数据")
public class SectionController {

    @Autowired
    private SectionDao sectionDao;


    @GetMapping("/singleLine")
    @ApiOperation(value = "单线路-展示线路断面", notes = "注意参数哦！\n" +
            "分别为：早高峰，晚高峰，全日(或者数字0,1,2)")
    public Object getSection(@RequestParam("time") String time,@RequestParam("lineID") String lineID) {
        String[] TIME={"早高峰","晚高峰","全天"};
        if(time.equals("0")||time.equals("1")||time.equals("2"))time=TIME[Integer.parseInt(time)];

        String line = lineID+"号线";

        List<SectionEntity>entities = sectionDao.getSectionList(time,line);

        Integer lineIndex=INDEX_OF_STRINGS(LINE_NAME,line);

        List<List<Integer>>data=CREATE_LISTS(2,STATION_OF_LINES[lineIndex].length,0);

        for(SectionEntity e:entities){
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
        SectionEntity up = sectionDao.getTopUp(time, line);
        SectionEntity down = sectionDao.getTopDown(time, line);
        JSONObject cardChart=new JSONObject(true);
        if(up!=null&&down!=null)
            cardChart=TWO_JSON("peakTime",peakTimeString[INDEX_OF_STRINGS(TIME,time)],
                "biggestSection",TWO_JSON("up",up.getStation(),
                        "down",down.getStation()));

        return BaseResult.ok(TWO_JSON("barChart",barChart,"cardChart",cardChart));


    }




}

