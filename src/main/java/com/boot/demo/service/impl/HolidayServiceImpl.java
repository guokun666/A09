package com.boot.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.components.common.constant.CommonConstants;
import com.boot.demo.dao.HolidayDao;
import com.boot.demo.entity.HolidayEntity;
import com.boot.demo.service.HolidayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 * @author CWZ
 */
@Slf4j
@Service
public class HolidayServiceImpl implements HolidayService {
    @Autowired
    private HolidayDao holidayDao;

    /*
    以下是城市
     */
    @Override
    public JSONObject getFlowByYear(Integer year) {
        List<HolidayEntity>entities=holidayDao.getFlowByYear(year);

        if(entities==null)return null;

        List<String> strings=new ArrayList<>();

        JSONObject barChart=new JSONObject(true);
        barChart.put("line", strings);
        List<JSONObject> series=new ArrayList<>();
        JSONObject s=new JSONObject(true);
        List<BigInteger>Data=new ArrayList<>();

        s.put("name","节假日");
        s.put("type","bar");
        s.put("data",Data);

        for(HolidayEntity e:entities){
            Integer index=CommonConstants.INDEX_OF_LIST(strings,e.getHoliday());
            if(index==-1){
                index=strings.size();
                strings.add(e.getHoliday());
                Data.add(BigInteger.ZERO);
            }
            Data.set(index,e.getDay_average());
        }

        series.add(s);
        barChart.put("series",series);

        return barChart;
    }

    @Override//各线路所有节假日日均客流量与工作日对比情况
    public JSONObject getAllLineHolidayAndWorkdayFlowByYear(Integer year) {
        List<HolidayEntity>entities=holidayDao.getAllLineHolidayAndWorkdayFlowByYear(year);

        if(entities==null)return null;

        String[] strings=CommonConstants.LINE_NAME;

        JSONObject barChart=new JSONObject(true);
        barChart.put("line", strings);
        List<JSONObject> series=new ArrayList<>();
        JSONObject s=new JSONObject(true);
        List<BigInteger>holidayData= Arrays.asList(new BigInteger[strings.length]);
        List<BigInteger>workdayData= Arrays.asList(new BigInteger[strings.length]);

        s.put("name","节假日");
        s.put("type","bar");
        s.put("data",holidayData);

        for(HolidayEntity e:entities){
            Integer index=CommonConstants.INDEX_OF_STRINGS(strings,e.getLine());
            holidayData.set(index,e.getHoliday_flow());
            workdayData.set(index,e.getWorkday_flow());
        }

        series.add((JSONObject) s.clone());
        s.replace("name","工作日");
        s.replace("data",workdayData);
        series.add((JSONObject) s.clone());

        barChart.put("series",series);

        return barChart;
    }

    /*
    以下是单线路
     */
    @Override
    public JSONObject getDuanFLowByLine(Integer year, String line){
        List<HolidayEntity>entities=holidayDao.getDuanFLowByLine(year,line);
        if(entities==null)return null;

        Integer lineIndex=CommonConstants.INDEX_OF_STRINGS(CommonConstants.LINE_NAME,line);
        if(lineIndex==-1)return null;

        String[] strings=CommonConstants.STATION_OF_LINES[lineIndex];

        JSONObject barChart=new JSONObject(true);
        barChart.put("line", strings);
        List<JSONObject> series=new ArrayList<>();
        JSONObject sHoliday=new JSONObject(true);
        List<BigInteger>holidayUpData= Arrays.asList(new BigInteger[strings.length]);
        List<BigInteger>workdayUpData= Arrays.asList(new BigInteger[strings.length]);
        List<BigInteger>holidayDownData= Arrays.asList(new BigInteger[strings.length]);
        List<BigInteger>workdayDownData= Arrays.asList(new BigInteger[strings.length]);

        sHoliday.put("name","节假日");
        sHoliday.put("type","bar");
        sHoliday.put("data",holidayUpData);

        JSONObject sWorkday=(JSONObject)sHoliday.clone();
        sWorkday.replace("data",workdayUpData);

        for(HolidayEntity e:entities){
            Integer index=CommonConstants.INDEX_OF_STRINGS(strings,e.getStation());
            holidayUpData.set(index,e.getHoliday_flow());
            workdayUpData.set(index,e.getWorkday_flow());
            holidayDownData.set(index,e.getHoliday_downflow());
            workdayDownData.set(index,e.getWorkday_downflow());
        }

        series.add(sHoliday);
        series.add(sWorkday);

        barChart.put("series",series);

        JSONObject json=new JSONObject(true);
        json.put("upBarChart",barChart.clone());

        sHoliday.replace("data",holidayDownData);
        sWorkday.replace("data",workdayDownData);

        json.put("downBarChart",barChart.clone());

        return json;
    }
}

