package com.boot.demo.service;


import com.boot.demo.entity.PeakPreditcEntity;
import com.boot.demo.entity.ShishiandPreditcEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShishiandPreditcService {//数据库的字段
    public List<ShishiandPreditcEntity> getCityFlow(String time_stamp);
    public List<ShishiandPreditcEntity> getLineFlow(String time_stamp);


}
