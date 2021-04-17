package com.boot.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.dao.WorkdayDao;
import com.boot.demo.entity.WorkdayEntity;
import com.boot.demo.service.WorkdayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

import static com.boot.demo.components.common.constant.CommonConstants.*;


/**
 * @author guokun
        */
@Slf4j
@Service
public class WorkdayServiceImpl implements WorkdayService {
    @Autowired
    private WorkdayDao workdayDao;

    public static final String[] NAME={"工作日","周末"};;

    @Override
    public JSONObject getYear(Integer b_year) {
        WorkdayEntity entity=workdayDao.getYear(b_year);
        if (entity==null)return null;
        String[] NAME={"整体","工作日","周末"};
        BigInteger[] value={entity.getAll(),entity.getWorkday(),entity.getWeekend()};
        return CARD_CHART_JSON(NAME,value);
    }
    @Override
    public JSONObject getMonth(Integer b_year) {
        List<WorkdayEntity> entities= workdayDao.getMonth(b_year);
        if (entities==null)return null;

        List<List<BigInteger>> data= CREATE_LISTS(NAME.length,MONTH.length,BigInteger.ZERO);

        for(WorkdayEntity e:entities){
            Integer index=e.getMonth()-1;
            data.get(0).set(index,e.getWorkday());
            data.get(1).set(index,e.getWeekend());
        }

        return CHART_JSON(MONTH,SERIES_LIST(NAME,"line",data));
    }
    @Override
    public JSONObject getLine(Integer b_year) {
        List<WorkdayEntity> entities = workdayDao.getLine(b_year);
        if(entities==null)return  null;

        List<List<BigInteger>> data= CREATE_LISTS(NAME.length,LINE_NUMBERS,BigInteger.ZERO);

        for(WorkdayEntity e:entities){
            Integer index=INDEX_OF_STRINGS(LINE_NAME,e.getSingleline());
            data.get(0).set(index,e.getWorkday());
            data.get(1).set(index,e.getWeekend());
        }

        return CHART_JSON(MONTH,SERIES_LIST(NAME,"bar",data));
    }
    @Override
    public JSONObject getSingleyear(Integer b_year, String line) {
        WorkdayEntity entity = workdayDao.getSingleyear(b_year,line);
        if (entity==null)return null;
        String[] NAME={"整体","工作日","周末"};
        BigInteger[] value={entity.getAll(),entity.getWorkday(),entity.getWeekend()};
        return CARD_CHART_JSON(NAME,value);
    }
    @Override
    public JSONObject getSinglemonth(Integer b_year, String line) {
        List<WorkdayEntity> entities = workdayDao.getSinglemonth(b_year,line);
        if (entities==null)return null;

        List<List<BigInteger>> data= CREATE_LISTS(NAME.length,MONTH.length,BigInteger.ZERO);

        for(WorkdayEntity e:entities){
            Integer index=e.getMonth()-1;
            data.get(0).set(index,e.getWorkday());
            data.get(1).set(index,e.getWeekend());
        }

        return CHART_JSON(MONTH,SERIES_LIST(NAME,"line",data));
    }
}

