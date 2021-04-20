package com.boot.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.dao.MonthPredictDao;
import com.boot.demo.entity.MonthPredictEntity;
import com.boot.demo.service.MonthPredictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.boot.demo.components.common.constant.CommonConstants.*;
import static com.boot.demo.components.common.constant.CommonConstants.SERIES_LIST;


/**
 * @author guokun
 */
@Slf4j
@Service
public class MonthPredictServiceImpl implements MonthPredictService {
    @Autowired
    private MonthPredictDao monthpreditcDao;

    @Override
    public List<MonthPredictEntity> getCityMonth() {
        return monthpreditcDao.getCityMonth();
    }
    @Override
    public List<MonthPredictEntity> getCityTop() {

        List<MonthPredictEntity> b=monthpreditcDao.getCityTopMax();
        b.addAll(monthpreditcDao.getCityTopMin());
        return b;
    }
    @Override
    public List<MonthPredictEntity> getStationMonth(Integer y_month) {
        return monthpreditcDao.getStationMonth(y_month);
    }

    //以下为单站-----------------------------------------------------------------------------------------
    @Override
    public JSONObject getStationSum(Integer y_day, String line, String station_name) {
        MonthPredictEntity e = monthpreditcDao.getStationSum(y_day,line,station_name);
        return TWO_JSON("allFlowIn",e.getFlow_in(),"allFlowOut",e.getFlow_out());
    }
    @Override
    public JSONObject getStationTime(Integer y_day, String line, String station) {
        JSONObject js=new JSONObject(true);

        if(INDEX_OF_STRINGS(LINE_NAME,line)==-1||
                INDEX_OF_STRINGS(STATION_OF_LINES[INDEX_OF_STRINGS(LINE_NAME,line)],station)==-1)
            return null;

        List<MonthPredictEntity> entities=new ArrayList<>();

        String[] NAME={"入站","出站"};

        String[] AXIS;
        Integer[] AXIS_NUMBER;

        entities=monthpreditcDao.getStationTime(y_day,line,station);
        AXIS_NUMBER=INIT_FROM_A_TO_B(6,23);
        AXIS=ADD_TO_STRING(AXIS_NUMBER,"");

        List<List<Integer>>data=CREATE_LISTS(2,AXIS.length,0);


        for(MonthPredictEntity e:entities){
            Integer index=INDEX_OF_STRINGS(AXIS_NUMBER,e.getTime());
//            System.out.println("in:"+e.getFlow_in()+",out:"+e.getFlow_out());
            data.get(0).set(index,e.getFlow_in());
            data.get(1).set(index,e.getFlow_out());
        }


        return CHART_JSON(AXIS,SERIES_LIST(NAME,"bar",data));
    }
    @Override
    public JSONObject getStationTop(Integer y_day, String line) {
        List<MonthPredictEntity>topIn = monthpreditcDao.getStationTopIn(y_day, line);
        List<MonthPredictEntity>topOut = monthpreditcDao.getStationTopOut(y_day, line);
        List<Object>dataIn=new ArrayList<>();
        for(MonthPredictEntity e:topIn)
            dataIn.add(TWO_JSON("name",e.getStation(),"flow",e.getFlow_in()));
        List<Object>dataOut=new ArrayList<>();
        for(MonthPredictEntity e:topIn)
            dataOut.add(TWO_JSON("name",e.getStation(),"flow",e.getFlow_in()));
        return TWO_JSON("topIn",dataIn,"topOut",dataOut);
    }

}

