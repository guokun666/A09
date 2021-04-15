package com.boot.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.dao.UserAgeDao;
import com.boot.demo.entity.UserAgeEntity;
import com.boot.demo.service.UserAgeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.boot.demo.components.common.constant.CommonConstants.*;


/**
 * @author guokun
 */
@Slf4j
@Service
public class UserAgeServiceImpl implements UserAgeService {
    @Autowired
    private UserAgeDao userAgeDao;

    @Override
    public JSONObject getUserAgeInformation(Integer year,String line) {
        //设置数组长度
        Integer dataLen=LINE_NUMBERS;

        Integer lineIndex=-1;
        //如果为单线路获取它的站点排序的index
        if(line!=null){
            lineIndex=INDEX_OF_STRINGS(LINE_NAME,line);
            dataLen=STATION_OF_LINES[lineIndex].length;
        }

        JSONObject json=new JSONObject(true);

        //添加线路名称json------全线路
        if(line==null)
            json.put("line",LINE_NAME);
        else//添加站点名称----------单线路
            json.put("line",STATION_OF_LINES[lineIndex]);
        //

        //填写series数据
        String color[]={"#FF0000","#F2FF00","#17CBFF","#00FFE2"};

        List<JSONObject> series=new ArrayList<>();
        JSONObject label=new JSONObject(true);
        label.put("show",true);
        JSONObject emphasis=new JSONObject(true);
        emphasis.put("focus","series");
        JSONObject itemStyle=new JSONObject(true);
        itemStyle.put("color",null);

        JSONObject it=new JSONObject(true);//存储一个数据
        it.put("name",null);
        it.put("type","bar");
        it.put("stack","total");
        it.put("label",label);
        it.put("emphasis",emphasis);
        it.put("itemStyle",itemStyle);
        it.put("data",null);

        List<BigInteger> dataYouth= Arrays.asList(new BigInteger[dataLen]);
        List<BigInteger> dataMidYouth=Arrays.asList(new BigInteger[dataLen]);
        List<BigInteger> dataMiddleAge=Arrays.asList(new BigInteger[dataLen]);
        List<BigInteger> dataOld=Arrays.asList(new BigInteger[dataLen]);
        //获取各个年龄段的(各线路)人数
        if(line==null){//全线路 获取对应线路 地址
            for(UserAgeEntity user:userAgeDao.getAllLineUserAgeByYear(year)){
                Integer index=INDEX_OF_STRINGS(LINE_NAME,user.getLineName());
                if(index==-1)return null;
                dataYouth.set(index,user.getYouth());
                dataMidYouth.set(index,user.getMidYouth());
                dataMiddleAge.set(index,user.getMiddleAge());
                dataOld.set(index,user.getOld());
            }
        }else{//单线路 获取对应站点 地址
            UserAgeEntity Line=userAgeDao.getSingleLineUserAgeByYearAndLine(year,line);
            for(UserAgeEntity station:userAgeDao.getStationUserAgeByYearAndLine(year,line)) {
                Integer index=INDEX_OF_STRINGS(STATION_OF_LINES[lineIndex],station.getStationName());
                if(index==-1)return null;
                dataYouth.set(index,station.getYouth());
                dataMidYouth.set(index,station.getMidYouth());
                dataMiddleAge.set(index,station.getMiddleAge());
                dataOld.set(index,station.getOld());
            }

            //计算各年龄段人数和以及比例

        }
        //给每个it赋予对应的 color和data
        //青年人
        itemStyle.replace("color",color[0]);
        it.replace("itemStyle",itemStyle.clone());
        it.replace("name","青少年");
        it.replace("data",dataYouth);
        series.add((JSONObject) it.clone());
        //中青年人
        itemStyle.replace("color",color[1]);
        it.replace("itemStyle",itemStyle.clone());
        it.replace("name","中青年");
        it.replace("data",dataMidYouth);
        series.add((JSONObject) it.clone());
        //中年人
        itemStyle.replace("color",color[2]);
        it.replace("itemStyle",itemStyle.clone());
        it.replace("name","中年");
        it.replace("data",dataMiddleAge);
        series.add((JSONObject) it.clone());
        //老年人
        itemStyle.replace("color",color[3]);
        it.replace("itemStyle",itemStyle.clone());
        it.replace("name","老年");
        it.replace("data",dataOld);
        series.add((JSONObject) it.clone());

        //加入series
        json.put("series",series);

        return json;
    }

    @Override
    public List<UserAgeEntity> getStationUserAgeByYearAndLine(Integer year, String line) {
        return userAgeDao.getStationUserAgeByYearAndLine(year, line);
    }


}

