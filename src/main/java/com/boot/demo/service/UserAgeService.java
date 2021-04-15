package com.boot.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.entity.UserAgeEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guokun
 */
@Service
public interface UserAgeService {

    //通过 年份 获取所有线路的用户年龄结构
    public JSONObject getUserAgeInformation(Integer year,String line);

    public List<UserAgeEntity> getStationUserAgeByYearAndLine(Integer year,String line);
}

