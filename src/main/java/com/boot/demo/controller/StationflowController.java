package com.boot.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.components.common.base.BaseResult;
import com.boot.demo.entity.StationflowEntity;
import com.boot.demo.service.StationflowService;
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
@RequestMapping("/historyData/stationFlow/singleLine")
@Api(tags = "历史数据")
public class StationflowController {

    @Autowired
    private StationflowService stationflowService;

    public static final String[] NAME={"入站","出站"};


//    @GetMapping("/station")
//    @ApiOperation(value = "根据年份和线路查询站点进出站客流", notes = "")
//    public Object getStationflow(@RequestParam("year") Integer year,
//                                 @RequestParam("lineID") String lineID,
//                                 @RequestParam("station")String station) {
//        JSONObject a =stationflowService.getStationflow(year,lineID+"号线",station);
//        return BaseResult.ok(a);
//    }
//    @GetMapping("/station/year")
//    @ApiOperation(value = "根据年份和线路查询站点的每月进出站客流", notes = "")
//    public Object getStationyear(@RequestParam("year") Integer year,@RequestParam("lineID") String lineID,
//                                 @RequestParam("station")String station) {
//        return stationflowService.getStationyear(year,lineID+"号线",station);
//    }
//    @GetMapping("/station/month")
//    @ApiOperation(value = "根据年份和线路,月份查询站点的每天进出站客流", notes = "")
//    public Object getStationmonth(@RequestParam("year") Integer year,@RequestParam("lineID") String lineID,
//                                 @RequestParam("station")String station,@RequestParam("month")Integer month) {
//        return stationflowService.getStationmonth(year,lineID+"号线",station,month);
//    }
    @GetMapping("chart")
    @ApiOperation(value = "单线路-站点进出站客流",
            notes = "2020-4-17\n" +
                    "根据年份和线路,月份以及日期查询站点的每天进出站客流\n" +
                    "获取两个数据，cardChart整体客流，barChart柱状图信息\n" +
                    "参数：\n" +
                    "lineID 线路号（必须）\n" +
                    "station 站点名（必须）\n" +
                    "year 年份（必须）\n" +
                    "month 月份（可不传）\n" +
                    "day 日期（可不传）\n")
    public Object getStationday(@RequestParam("year") Integer year,
                                @RequestParam("lineID") String lineID,
                                @RequestParam("station")String station,
                                @RequestParam(value = "month",required = false)Integer month,
                                @RequestParam(value = "day",required = false)Integer day) {
        JSONObject js=new JSONObject(true);
        String line=lineID+"号线";

        if(INDEX_OF_STRINGS(LINE_NAME,line)==-1)return BaseResult.error(line+"不存在哦！");

        if(INDEX_OF_STRINGS(STATION_OF_LINES[INDEX_OF_STRINGS(LINE_NAME,line)],station)==-1)
            return BaseResult.error(line+"不存在站点"+station+"哦！");

        List<StationflowEntity>entities=new ArrayList<>();

        String[] NAME={"入站","出站"};

        String[] AXIS;
        Integer[] AXIS_NUMBER;

        if(day!=null){
            entities=stationflowService.getStationday(year,line,station,month,day);
            AXIS_NUMBER=INIT_FROM_A_TO_B(6,23);
            AXIS=ADD_TO_STRING(AXIS_NUMBER,"");
        }
        else if(month!=null){
            entities=stationflowService.getStationmonth(year,line,station,month);
            AXIS_NUMBER=INIT_FROM_A_TO_B(1,DAYS_OF_MONTH_IN_YEAR(year,month));
            AXIS=ADD_TO_STRING(AXIS_NUMBER,"");
        }
        else {
            entities=stationflowService.getStationyear(year,line,station);
            AXIS_NUMBER=INIT_FROM_A_TO_B(1,12);
            AXIS=ADD_TO_STRING(AXIS_NUMBER,"月");
        }

        List<List<Integer>>data=CREATE_LISTS(2,AXIS.length,0);

        Long sumFlowIn= 0L,sumFlowOut= 0L;

        for(StationflowEntity e:entities){
            Integer index=INDEX_OF_STRINGS(AXIS_NUMBER,e.getTime());
//            System.out.println("in:"+e.getFlow_in()+",out:"+e.getFlow_out());
            if(e.getFlow_in()!=null){
                data.get(0).set(index,e.getFlow_in());
                sumFlowIn+=e.getFlow_in();
            }
            if(e.getFlow_out()!=null){
                data.get(1).set(index,e.getFlow_out());
                sumFlowOut+=e.getFlow_out();
            }

        }

        js.put("cardChart",TWO_JSON("flowIn",sumFlowIn, "flowOut",sumFlowOut));

        js.put("barChart",CHART_JSON(AXIS,SERIES_LIST(NAME,"bar",data)));

        return BaseResult.ok(js);
    }
    @GetMapping("top")
    @ApiOperation(value = "单线路-进出站客流前三",
            notes = "由年份,线路获取(如果该线路站点总数少于三个会有bug！当然一般不会出现这种情况)")
    public Object getTop(@RequestParam("year") Integer year,@RequestParam("lineID")String lineID) {
        List<StationflowEntity>entities = stationflowService.getTop(year,lineID+"号线");
        List<String>name=new ArrayList<>();
        List<Integer>flow=new ArrayList<>();

        for(StationflowEntity e:entities){
            name.add(e.getStation());
            if(e.getFlow_in()==null)
                flow.add(e.getFlow_out());
            else
                flow.add(e.getFlow_in());
        }

        return BaseResult.ok(
                TWO_JSON_LIST("flowInTop3",
                        TWO_JSON_LIST("name",name.subList(0,3),"flow",flow.subList(0,3)),
                        "flowOutTop3",
                        TWO_JSON_LIST("name",name.subList(3,6),"flow",flow.subList(3,6))
                )
        );
    }



}

