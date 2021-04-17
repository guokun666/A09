package com.boot.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.components.common.constant.CommonConstants;
import com.boot.demo.dao.WeatherDao;
import com.boot.demo.entity.WeatherEntity;
import com.boot.demo.service.WeatherService;
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
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    private WeatherDao weatherDao;

    public List<Object> CardJSON(List<WeatherEntity> weatherEntities){
        if(weatherEntities==null)return null;

        List<Object> cardChart=new ArrayList<>();
        JSONObject card=new JSONObject(true);
        BigInteger sunnyFlow=BigInteger.ZERO,rainyFlow=BigInteger.ZERO,cloudyFlow=BigInteger.ZERO;

        for(WeatherEntity w:weatherEntities){
            switch (w.getWeather()){
                case 1:sunnyFlow=w.getFlow().add(sunnyFlow);break;//晴天
                case 2:cloudyFlow=w.getFlow().add(cloudyFlow);break;//阴天
                case 3:rainyFlow=w.getFlow().add(rainyFlow);break;//雨天
            }

        }

        card.put("name","晴天日均客流");
        card.put("value",sunnyFlow);
        cardChart.add(card.clone());

        card.replace("name","阴天日均客流");
        card.replace("value",cloudyFlow);
        cardChart.add(card.clone());

        card.replace("name","雨天日均客流");
        card.replace("value",rainyFlow);
        cardChart.add(card);

        return cardChart;
    }

    public JSONObject LineJSON(List<WeatherEntity> weatherEntities){
        if(weatherEntities==null)return null;

        JSONObject lineChart=new JSONObject(true);
        lineChart.put("line", CommonConstants.MONTH);
        List<JSONObject> series=new ArrayList<>();
        JSONObject s=new JSONObject(true);
        List<BigInteger>sunnyData=Arrays.asList(new BigInteger[CommonConstants.MONTH.length]);
        List<BigInteger>cloudyData=Arrays.asList(new BigInteger[CommonConstants.MONTH.length]);
        List<BigInteger>rainyData=Arrays.asList(new BigInteger[CommonConstants.MONTH.length]);
        s.put("name","晴天");
        s.put("type","line");
        s.put("data",sunnyData);

        for(WeatherEntity w:weatherEntities){
            Integer index=w.getMonth()-1;
            switch (w.getWeather()){
                case 1:sunnyData.set(index,w.getFlow());break;//晴天
                case 2:cloudyData.set(index,w.getFlow());break;//阴天
                case 3:rainyData.set(index,w.getFlow());break;//雨天
            }
        }

        series.add((JSONObject)s.clone());

        s.replace("name","阴天");
        s.replace("data",cloudyData);
        series.add((JSONObject)s.clone());

        s.replace("name","雨天");
        s.replace("data",rainyData);
        series.add((JSONObject)s.clone());

        lineChart.put("series",series);

        return lineChart;
    }

    public JSONObject BarJSON(List<WeatherEntity> weatherEntities) {
        if(weatherEntities==null)return null;

        JSONObject barChart=new JSONObject(true);
        barChart.put("line", CommonConstants.LINE_NAME);
        List<JSONObject> series=new ArrayList<>();
        JSONObject s=new JSONObject(true);
        List<BigInteger>sunnyData=Arrays.asList(new BigInteger[CommonConstants.LINE_NUMBERS]);
        List<BigInteger>cloudyData=Arrays.asList(new BigInteger[CommonConstants.LINE_NUMBERS]);
        List<BigInteger>rainyData=Arrays.asList(new BigInteger[CommonConstants.LINE_NUMBERS]);
        s.put("name","晴天");
        s.put("type","bar");
        s.put("data",sunnyData);

        for(WeatherEntity w:weatherEntities){
            Integer index=CommonConstants.INDEX_OF_STRINGS(CommonConstants.LINE_NAME,w.getLine());
            switch (w.getWeather()){
                case 1:sunnyData.set(index,w.getFlow());break;//晴天
                case 2:cloudyData.set(index,w.getFlow());break;//阴天
                case 3:rainyData.set(index,w.getFlow());break;//雨天
            }
        }

        series.add((JSONObject)s.clone());
        s.replace("name","阴天");
        s.replace("data",cloudyData);
        series.add((JSONObject)s.clone());
        s.replace("name","雨天");
        s.replace("data",rainyData);
        series.add((JSONObject)s.clone());
        barChart.put("series",series);

        return barChart;
    }

    /*
    以下是城市
     */
    @Override
    public List<Object> getCardFlowByYear(Integer year) {
        List<WeatherEntity>weatherEntities = weatherDao.getCardFlowByYear(year);
        return CardJSON(weatherEntities);
    }

    @Override
    public BigInteger getAllFlowByYear(Integer year) {
        WeatherEntity weatherEntity=weatherDao.getAllFlowByYear(year);
        if(weatherEntity==null)return null;
        return weatherEntity.getFlow();
    }

    @Override//折线图
    public JSONObject getZheFlowByYear(Integer year) {
        List<WeatherEntity>weatherEntities=weatherDao.getZheFlowByYear(year);
        return LineJSON(weatherEntities);
    }

    @Override//柱状图
    public JSONObject getZhuFlowByYear(Integer year) {
        List<WeatherEntity>weatherEntities = weatherDao.getZhuFlowByYear(year);
        return BarJSON(weatherEntities);
    }

    /*
    以下是单线路
     */
    @Override
    public BigInteger getAllFlowByYearAndLine(Integer year, String line) {
        WeatherEntity weatherEntities = weatherDao.getAllFlowByYearAndLine(year, line);
        if(weatherEntities==null)return null;
        return weatherEntities.getFlow();
    }

    @Override
    public List<Object> getCardFlowByYearAndLine(Integer year, String line) { return CardJSON(weatherDao.getCardFlowByYearAndLine(year, line)); }

    @Override
    public JSONObject getZheFlowByYearAndLine(Integer year, String line) { return LineJSON(weatherDao.getZheFlowByYearAndYear(year, line)); }
}

