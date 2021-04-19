package com.boot.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.components.common.base.BaseResult;
import com.boot.demo.entity.FlowEventEntity;
import com.boot.demo.service.FlowEventService;
import com.boot.demo.service.HolidayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.boot.demo.components.common.constant.CommonConstants.*;


/**
 * @author guokun
 * @date 2021-4-17
 */
@Slf4j
@RestController
@RequestMapping("realData/flowEvent")
@Api(tags = "实时数据")
public class FlowEventController {

    @Autowired
    private FlowEventService flowEventService;

//    @ApiOperation(value = "突发事件上报")
//    @PostMapping("insert")
//    @ResponseBody
//    public Object insertNewEvent(@RequestBody FlowEventEntity eventEntity){
//        System.out.println(BaseResult.ok(eventEntity));
//        flowEventService.insertNewEvent(eventEntity);
//        return BaseResult.ok();
//    }

    @ApiOperation(value = "突发事件-突发事件上报")
    @GetMapping("insert")
    public Object insertNewEvent(@RequestParam("time")String time,
                                 @RequestParam("station")String station,
                                 @RequestParam("type")String type,
                                 @RequestParam("description")String description,
                                 @RequestParam(value = "isDone",required = false)Boolean isDone){
        FlowEventEntity e=new FlowEventEntity();
        if(isDone!=null)e.setDone(isDone?1:0);
        if(station!=null)e.setStationName(station);
        e.setEventDescription(description);
        e.setEventTime(time);
        e.setEventType(type);
        flowEventService.insertNewEvent(e);
        return BaseResult.ok();
    }

    @ApiOperation(value = "突发事件-查询某一天的所有突发事件")
    @GetMapping("selectByDate")
    public Object selectByDate(@RequestParam("date")String date){
        return BaseResult.ok(flowEventService.selectEventsByDay(date));
    }

    @ApiOperation(value = "突发事件-查询[某线路]某一天的所有突发事件")
    @GetMapping("selectByDateAndLine")
    public Object selectByDate(@RequestParam("date")String date,@RequestParam("lineID")Integer lineID){
        List<FlowEventEntity>events = flowEventService.selectEventsByDay(date);
        if (events==null)return BaseResult.ok(null);

        Integer lineIndex=INDEX_OF_STRINGS(LINE_ID,lineID);

        List<FlowEventEntity>ansEvents=new ArrayList<>();

        for(int i=0;i<events.size();i++){//获取该线路的事件
            if(INDEX_OF_STRINGS(STATION_OF_LINES[lineIndex],events.get(i).getStationName())!=-1)
                ansEvents.add(events.get(i));
        }

        return BaseResult.ok(ansEvents);
    }

    @ApiOperation(value = "突发事件-设置事件完成或者未完成",
            notes = "传送一个eventID给我我将isDone属性翻转")
    @GetMapping("setDoneOrNotDone")
    public Object setDoneOrNotDoneByID(@RequestParam("ID")Integer ID){
        flowEventService.setDoneOrNotDoneByID(ID);
        return BaseResult.ok();
    }

}
