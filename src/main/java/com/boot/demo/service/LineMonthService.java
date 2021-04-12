package com.boot.demo.service;


import com.boot.demo.entity.LineMonthEntity;
import org.springframework.stereotype.Service;
@Service
public interface LineMonthService {
    public  LineMonthEntity getBYAyl(Integer a_year, String line);
}
