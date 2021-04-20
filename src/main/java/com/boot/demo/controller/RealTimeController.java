package com.boot.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.components.common.base.BaseResult;
import com.boot.demo.components.common.constant.CommonConstants;
import com.boot.demo.entity.FlowEntity;
import com.boot.demo.entity.StationRealTimeEntity;
import com.boot.demo.entity.TrainOnlineBarEntity;
import com.boot.demo.entity.TrainsRealTimeEntity;
import com.boot.demo.service.RealTimeService;
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


/**
 * @author guokun
 * @date 2021-4-17
 */
@Slf4j
@RestController
@RequestMapping("realData/realTime")
@Api(tags = "实时数据")
public class RealTimeController {

    @Autowired
    private RealTimeService realTimeService;

    //-------------------------函数-----------------------------
    public static String flowGrade(Integer n){
        if(n<2)return "正常";
        if(n<4)return "拥挤";
        return "非常拥挤";
    }
    //-------------------------函数-----------------------------

    @ApiOperation(value = "城市-城市实时信息",notes = "")
    @GetMapping("RealTimeCityInformation")
    public Object getCityInformation(@RequestParam(value = "time",required = false)Long time){
        time=GET_STAMP();

        //线路实时预测


        //各线路实时客流
        List<FlowEntity>allLineRealTimeFlow=realTimeService.getCityRealTimeFlow(time);
        String[] realGroup={"进站客流","出站客流"};
        List<List<Integer>>realData=CREATE_LISTS(realGroup.length,LINE_NUMBERS,0);

        for(FlowEntity e:allLineRealTimeFlow){
            Integer index=INDEX_OF_STRINGS(LINE_NAME,e.getLine());
            realData.get(0).set(index,e.getFlowIn());
            realData.get(1).set(index,e.getFlowOut());
        }

        JSONObject realJson=CHART_JSON(LINE_NAME,SERIES_LIST(realGroup,"bar",realData));

        //实时车辆运营监测
        List<TrainOnlineBarEntity>trainOnline=realTimeService.getTrainOnlineBar();
        String[] onlineGroup={"运营车辆","在库车辆"};
        List<List<Integer>>onlineData=CREATE_LISTS(onlineGroup.length,LINE_NUMBERS,0);

        for(TrainOnlineBarEntity e:trainOnline){
            Integer index=INDEX_OF_STRINGS(LINE_NAME,e.getLine());
            onlineData.get(0).set(index,e.getOnlineNumber());
            onlineData.get(1).set(index,e.getNotOnlineNumber());
        }

        JSONObject onlineJson=CHART_JSON(LINE_NAME,SERIES_LIST(onlineGroup,"bar",onlineData));

        return BaseResult.ok(TWO_JSON("linesRealTimeBarChart",realJson,
                "trainsOnlineBarChart",onlineJson));
    }



    @ApiOperation(value = "单线路-获取线路实时信息",
            notes = "线路ID(lineID)")
    @GetMapping("RealTimeLineInformation")
    public Object getLineInformation(@RequestParam("lineID")Integer lineID,
                                       @RequestParam(value = "time",required = false)Long time){
        String line=lineID+"号线";

        //扭转时间戳
//        if(time==null)
//            time=GET_STAMP();
//        else
//            time=GET_STAMP(time);

        time=GET_STAMP();

        List<StationRealTimeEntity>sEntities= realTimeService.getSingleLineRealTimeStationFlow(line,time);

        List<TrainsRealTimeEntity>tEntities=realTimeService.getSingleLineRealTimeTrainFlow(line,time);

        Integer lineIndex=INDEX_OF_STRINGS(LINE_ID,lineID);

        String[] STA= STATION_OF_LINES[lineIndex];

        //站点实时数据
        String[] sHEAD={"name","arrivalFlow","inboundFlow","outboundFlow","level"};
        List<List<String>>sData=CREATE_LISTS(STA.length,sHEAD.length,"0");
        //站点实时数据（柱状图）
        String[] barHEAD={"进站客流","出站客流"};
        List<List<Integer>>barData=CREATE_LISTS(barHEAD.length,STA.length,0);

        //列车实时数据
        String[] tHEAD={"id","state","load","speed","stopStation","frontStation","isToStation"};
        List<List<String>>tData=CREATE_LISTS(tEntities.size(),tHEAD.length,"false");

        //初始化数据
        for(int i=0;i<STA.length;i++){
            sData.get(i).set(0,STA[i]);
            sData.get(i).set(1,"暂无即将到站列车");
            sData.get(i).set(4,"正常");
        }

        for(StationRealTimeEntity e:sEntities){
            Integer index=INDEX_OF_STRINGS(STA,e.getStationName());
            sData.get(index).set(2,e.getFlowIn()+"");
            sData.get(index).set(3,e.getFlowOut()+"");
            //这里是定义客流聚集等级的
            sData.get(index).set(4,flowGrade(e.getFlowIn()));

            //柱状图的信息
            barData.get(0).set(index,e.getFlowIn());
            barData.get(1).set(index,e.getFlowOut());
        }

        for(int i=0;i<tEntities.size();i++){
            //站点信息要用到的列车信息
            Integer index=INDEX_OF_STRINGS(STA,tEntities.get(i).getNextStation());
            sData.get(index).set(1,tEntities.get(i).getTWeight()/60+"");

            //列车实时信息
            tData.get(i).set(0,tEntities.get(i).getTid()+"");
            tData.get(i).set(1,"true");
            tData.get(i).set(2,tEntities.get(i).getTWeight()+"kg");
            tData.get(i).set(3,tEntities.get(i).getTSpeed()+"km/h");
            tData.get(i).set(4,tEntities.get(i).getLastStation());
            tData.get(i).set(5,tEntities.get(i).getNextStation());
            tData.get(i).set(6,(tEntities.get(i).getIsRun() == 1)+"");
        }

        return BaseResult.ok(THREE_JSON(
                "trainData",SERIES_COLUMNS(tHEAD,tData),
                "stationData",SERIES_COLUMNS(sHEAD,sData),
                "realPassengerFlowEchartData",CHART_JSON(
                        STA,SERIES_LIST(barHEAD,"bar",barData)
                )
        ));
//        return time;
    }

}
