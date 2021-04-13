package com.boot.demo.service;


import com.boot.demo.entity.LineMonthEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LineMonthService {
    public List<LineMonthEntity> getBYAyl(Integer a_year, String line);


}
