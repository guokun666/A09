package com.boot.demo.service;


import com.boot.demo.entity.SectionPreditcEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SectionPreditcService {//数据库的字段

    public List<SectionPreditcEntity> getSection(String time_slot, String line,Integer y_day);
}
