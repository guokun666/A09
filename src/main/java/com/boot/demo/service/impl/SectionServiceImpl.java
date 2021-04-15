package com.boot.demo.service.impl;

import com.boot.demo.dao.SectionDao;
import com.boot.demo.entity.SectionEntity;
import com.boot.demo.service.SectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author guokun
        */
@Slf4j
@Service
public class SectionServiceImpl implements SectionService {
    @Autowired
    private SectionDao sectionDao;


    @Override
    public List<SectionEntity> getSection(String time_slot,String line) {//数据库的字段名
        List<SectionEntity> a=sectionDao.getSectionList(time_slot,line);
        a.addAll(sectionDao.getTopUp(time_slot,line));
        a.addAll(sectionDao.getTopDown(time_slot,line));
        return a;
    }


}
