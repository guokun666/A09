package com.boot.demo.service.impl;

import com.boot.demo.dao.SectionPredictDao;
import com.boot.demo.entity.SectionPredictEntity;
import com.boot.demo.service.SectionPredictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guokun
        */
@Slf4j
@Service
public class SectionPredictServiceImpl implements SectionPredictService {
    @Autowired
    private SectionPredictDao sectionpreditcDao;


    @Override
    public List<SectionPredictEntity> getSection(String time_slot, String line, Integer y_day) {//数据库的字段名
        List<SectionPredictEntity> a=sectionpreditcDao.getSectionList(time_slot,line,y_day);
        a.addAll(sectionpreditcDao.getTopUp(time_slot,line,y_day));
        a.addAll(sectionpreditcDao.getTopDown(time_slot,line,y_day));
        return a;
    }


}

