package com.boot.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.entity.UserAgeEntity;
import com.boot.demo.service.UserAgeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import static com.boot.demo.components.common.constant.CommonConstants.*;


/**
 * @author guokun
 * @email 317557750@qq.com
 * @date 2021-4-13
 */
@Slf4j
@RestController
@RequestMapping("historydata/age")
@Api(tags = "历史数据")
public class UserAgeController {

    @Autowired
    private UserAgeService userAgeService;

    //通过 年份 获取所有线路的用户年龄结构
    @ApiOperation(
            value = "城市-用户年龄结构信息",
            notes = "修改时间：2020-4-13\n" +
                    "通过输入一个参数 年份（int） 获取所有线路用户年龄结构信息(lineUserAge[])")
    @GetMapping("city")
    public Object getAllLineUserAgeByYear(@RequestParam("year") Integer year){
        return userAgeService.getUserAgeInformation(year,null);
    }

    //通过 年份、线路名 获取该线路的用户年龄结构柱状图信息 以及 表格信息
    @ApiOperation(
            value = "单线路-用户年龄结构信息",
            notes = "修改时间：2020-4-13\n" +
                    "通过输入两个参数 年份，线路名 获取所有线路用户年龄结构信息\n" +
                    "返回两个数组 table[] 和 bar[] 分别表示 表数据 和 柱状图数据\n")
    @GetMapping("signal_line")
    public Object getSignalLineUserAge(@RequestParam("year") Integer year,
                                       @RequestParam("line") String line){
        if(INDEX_OF_STRINGS(LINE_NAME,line)==-1){//线路输入不合法{
            JSONObject js400=new JSONObject(true);
            js400.put("code",400);
            js400.put("msg","线路不存在！请重试！");
        }

        JSONObject bar = userAgeService.getUserAgeInformation(year,line);
        List<JSONObject> table = new ArrayList<>();
        JSONObject json = new JSONObject(true);

        BigInteger youth=BigInteger.valueOf(0);
        BigInteger midYouth=BigInteger.valueOf(0);
        BigInteger middleAge=BigInteger.valueOf(0);
        BigInteger old=BigInteger.valueOf(0);
        //获取table信息
        for(UserAgeEntity station:userAgeService.getStationUserAgeByYearAndLine(year, line)){
            youth=youth.add(station.getYouth());
            midYouth=midYouth.add(station.getMidYouth());
            middleAge=middleAge.add(station.getMiddleAge());
            old=old.add(station.getOld());
        }

        double all=(youth.add(middleAge).add(midYouth).add(old)).doubleValue();
        NumberFormat nf=NumberFormat.getPercentInstance();
        nf.setMaximumFractionDigits(0);

        JSONObject tableJson=new JSONObject(true);

        tableJson.put("type","青少年");
        tableJson.put("num",youth);
        if(youth.equals(0)&&midYouth.equals(0)&&middleAge.equals(0)&&old.equals(0)){
            tableJson.put("proportion","0%");
        }else tableJson.put("proportion",nf.format(youth.doubleValue()/all));
        table.add((JSONObject) tableJson.clone());

        tableJson.put("type","中青年");
        tableJson.put("num",midYouth);
        tableJson.put("proportion",nf.format(midYouth.doubleValue()/all));
        table.add((JSONObject) tableJson.clone());

        tableJson.put("type","中年");
        tableJson.put("num",middleAge);
        tableJson.put("proportion",nf.format(middleAge.doubleValue()/all));
        table.add((JSONObject) tableJson.clone());

        tableJson.put("type","老年");
        tableJson.put("num",old);
        tableJson.put("proportion",nf.format(old.doubleValue()/all));
        table.add((JSONObject) tableJson.clone());

        json.put("table",table);
        json.put("bar",bar);

        return  json;
    }


}
