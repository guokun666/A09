package com.boot.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.dao.PeakDao;
import com.boot.demo.entity.PeakEntity;
import com.boot.demo.service.PeakService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static com.boot.demo.components.common.constant.CommonConstants.*;

/**
 * @author guokun
        */
@Slf4j
@Service
public class PeakServiceImpl implements PeakService {
    @Autowired
    private PeakDao peakDao;

    Integer[] TIME=INIT_FROM_A_TO_B(6,23);

    public static JSONObject JSON(PeakEntity percentEntity,JSONObject lineChart){
        if (percentEntity==null)return lineChart;
        JSONObject js = new JSONObject(true);
        js.put("lineChart", lineChart);
        js.put("morningPercent", percentEntity.getMoringpercentage());
        js.put("eveningPercent", percentEntity.getEveningpercentage());
        return js;
    }

    @Override
    public JSONObject getCity(Integer e_year) {//数据库的字段名
        List<PeakEntity> entities = peakDao.getCityPeak(e_year);
        if (entities==null)return null;

        List<List<Integer>> data = CREATE_LISTS(LINE_NUMBERS, TIME.length, 0);

        for (PeakEntity e : entities)//System.out.println(e.getTime());
            data.get(INDEX_OF_STRINGS(LINE_NAME, e.getSingleline()))
                    .set(INDEX_OF_STRINGS(TIME, e.getTime()), e.getFlow());

        JSONObject lineChart = CHART_JSON(TIME, SERIES_LIST(LINE_NAME, "line", data));

        return JSON(peakDao.getCityPercentage(e_year),lineChart);
    }
    @Override
    public JSONObject getLine(Integer e_year, String line) {//数据库的字段名
        List<PeakEntity> entities = peakDao.getLinePeak(e_year,line);
        if (entities==null)return null;

        List<Integer> data = Arrays.asList(new Integer[TIME.length]);

        for (PeakEntity e : entities)//System.out.println(e.getMonth());
            data.set(INDEX_OF_STRINGS(TIME,e.getTime()),e.getFlow());

        JSONObject lineChart = CHART_JSON(TIME, data);

        return JSON(peakDao.getLinePercentage(e_year, line),lineChart);
    }
    @Override
    public JSONObject getLineMonth(Integer e_year, String line, Integer e_month) {//数据库的字段名
        List<PeakEntity> entities = peakDao.getLineMonthPeak(e_year,line,e_month);
        if (entities==null)return null;

        List<Integer> data = Arrays.asList(new Integer[TIME.length]);

        for (PeakEntity e : entities)//System.out.println(e.getMonth());
            data.set(INDEX_OF_STRINGS(TIME,e.getTime()),e.getFlow());

        JSONObject lineChart = CHART_JSON(TIME, data);

        return JSON(peakDao.getLineMonthPercentage(e_year,line,e_month),lineChart);
    }

}

