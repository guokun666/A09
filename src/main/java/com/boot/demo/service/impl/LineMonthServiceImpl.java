package com.boot.demo.service.impl;

import com.boot.demo.dao.LineMonthDao;
import com.boot.demo.entity.LineMonthEntity;
import com.boot.demo.service.LineMonthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author guokun
 */
@Slf4j
@Service
public class LineMonthServiceImpl implements LineMonthService {
    @Autowired
    private LineMonthDao lineMonthDao;

    @Override
    public LineMonthEntity getBYAyl(Integer a_year, String line) {
        return lineMonthDao.getBYAyl(a_year,line);
    }
}

