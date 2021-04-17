package com.boot.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.dao.LineMonthDao;
import com.boot.demo.entity.LineMonthEntity;
import com.boot.demo.service.LineMonthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;

import static com.boot.demo.components.common.constant.CommonConstants.*;


/**
 * @author guokun
 */
@Slf4j
@Service
public class LineMonthServiceImpl implements LineMonthService {
    @Autowired
    private LineMonthDao lineMonthDao;

    @Override
    public JSONObject getBYAyl(Integer a_year, String line) {
        List<LineMonthEntity>entities = lineMonthDao.getBYAyl(a_year, line);
        if(entities==null)return null;

        List<Object>series=new ArrayList<>();

        List<BigInteger>flowData = Arrays.asList(new BigInteger[MONTH.length]);

        for(LineMonthEntity e:entities){
            flowData.set(e.getMonth()-1,e.getFlow());
        }

        return CHART_JSON(MONTH,flowData);
    }
    @Override
    public JSONObject getByMonth(Integer a_year, String line, Integer a_month) {
        List<LineMonthEntity>entities = lineMonthDao.getByMonth(a_year,line,a_month);
        if(entities==null)return null;

        List<Object>series=new ArrayList<>();

        int daysOfMonth=DAYS_OF_MONTH_IN_YEAR(a_year,a_month);
        Integer[] days=INIT_FROM_1_TO_END(new Integer[daysOfMonth]);

        List<BigInteger>flowData = Arrays.asList(new BigInteger[daysOfMonth]);

        for(LineMonthEntity e:entities){
            flowData.set(e.getDate()-1,e.getFlow());
        }

        return CHART_JSON(days,flowData);
    }
    @Override
    public JSONObject getCitymonth(Integer a_year) {
        List<LineMonthEntity>entities = lineMonthDao.getCitymonth(a_year);
        if(entities==null)return null;

        List<Object>series=new ArrayList<>();

        List<List<BigInteger>>flowData = CREATE_LISTS(LINE_NUMBERS,MONTH.length,BigInteger.ZERO);

        for(LineMonthEntity e:entities){
            Integer monthIndex=e.getMonth()-1;
            Integer lineIndex=INDEX_OF_STRINGS(LINE_NAME,e.getSingleline());
            flowData.get(lineIndex).set(monthIndex,e.getFlow());
        }

        return CHART_JSON(MONTH,SERIES_LIST(ADD_TO_STRING(LINE_ID,"线"),"line",flowData));
    }
    @Override
    public JSONObject getCityline(Integer a_year, Integer a_month ) {
        List<LineMonthEntity>entities = lineMonthDao.getCityline(a_year,a_month);
        if(entities==null)return null;

        List<Object>series=new ArrayList<>();

        List<BigInteger>flowData = Arrays.asList(new BigInteger[LINE_NUMBERS]);

        for(LineMonthEntity e:entities){
            Integer lineIndex=INDEX_OF_STRINGS(LINE_NAME,e.getSingleline());
            flowData.set(lineIndex,e.getFlow());
        }

        return CHART_JSON(ADD_TO_STRING(LINE_ID,"线"),flowData);
    }
    @Override//每个线路 的某月 所有日的客流
    public JSONObject getCitydate(Integer a_year, Integer a_month ) {
        List<LineMonthEntity> entities =  lineMonthDao.getCitydate(a_year,a_month);
        if(entities==null)return null;

        List<Object>series=new ArrayList<>();

        int daysOfMonth=DAYS_OF_MONTH_IN_YEAR(a_year,a_month);

        List<List<BigInteger>>flowData = CREATE_LISTS(LINE_NUMBERS,daysOfMonth,BigInteger.ZERO);

        Integer[] days=INIT_FROM_1_TO_END(new Integer[daysOfMonth]);


        for(LineMonthEntity e:entities){
//            System.out.println(e);
            Integer lineIndex=INDEX_OF_STRINGS(LINE_NAME,e.getSingleline());
            Integer dayIndex=e.getDate()-1;
            flowData.get(lineIndex).set(dayIndex,e.getFlow());
        }

        //当月所有日期
        return CHART_JSON(days,SERIES_LIST(LINE_NAME,"line",flowData));
    }

}

