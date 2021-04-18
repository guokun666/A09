package com.boot.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.dao.InstantaneousDao;
import com.boot.demo.entity.InstantaneousEntity;
import com.boot.demo.service.InstantaneousService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.boot.demo.components.common.constant.CommonConstants.*;


/**
 * @author CWZ
 */
@Slf4j
@Service
public class InstantaneousServiceImpl implements InstantaneousService {
    @Autowired
    private InstantaneousDao InstantaneousDao;

    public static List<String> AXIS=new ArrayList<>();
    public static String[] NAME={"flowIn","flowOut"};
    public static List<List<Integer>> data;
    static {
        for(int i=6;i<24;i++){
            for(int j=0;j<60;j+=15){
                AXIS.add(i+":"+j);
            }
        }
        data=CREATE_LISTS(2,AXIS.size(),0);
    }

    /*
    全天瞬时客流
     */

    public JSONObject getDayFlowByDayAndStation(String time, String station)
    {
        List<InstantaneousEntity> days= InstantaneousDao.getDayFlowByDayAndStation(time, station);
        List<InstantaneousEntity> years=InstantaneousDao.getYearFlowByYearAndStation(station);

        if(days==null||years==null)return null;

        for(InstantaneousEntity e:days){
            Integer index=INDEX_OF_LIST(AXIS,e.getTime());
            data.get(0).set(index,e.getFlow_in());
            data.get(1).set(index,e.getFlow_out());
        }

        JSONObject dayJson= TWO_JSON(NAME[0],CHART_JSON(AXIS.toArray(), new ArrayList<>(data.get(0))),
                NAME[1],CHART_JSON(AXIS.toArray(), new ArrayList<>(data.get(1))));

        for(InstantaneousEntity e:years){
            Integer index=INDEX_OF_LIST(AXIS,e.getTime());
            data.get(0).set(index,e.getFlow_in());
            data.get(1).set(index,e.getFlow_out());
        }

        JSONObject yearJSon=TWO_JSON(NAME[0],CHART_JSON(AXIS.toArray(), new ArrayList<>(data.get(0))),
                NAME[1],CHART_JSON(AXIS.toArray(), new ArrayList<>(data.get(1))));

        return TWO_JSON("dayJson",dayJson,"yearJSon",yearJSon);

    }

    /*
    全年瞬时客流
     */

    public List<InstantaneousEntity> getYearFlowByYearAndStation(String station)
    {
        return InstantaneousDao.getYearFlowByYearAndStation(station);
    }

}

