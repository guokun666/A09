package com.boot.demo.service;


import com.boot.demo.entity.ODPreditcEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ODPreditcService {//数据库的字段
    public List<ODPreditcEntity> getOD(Integer y_day,String line);
}
