package com.boot.demo.service;


import com.boot.demo.entity.SectionEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SectionService {//数据库的字段

    public List<SectionEntity> getSection(String time_slot, String line);
}
