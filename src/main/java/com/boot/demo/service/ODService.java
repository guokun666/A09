package com.boot.demo.service;


import com.boot.demo.entity.ODEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ODService {//数据库的字段
    public List<ODEntity> getOD(String f_date,String line);
}
