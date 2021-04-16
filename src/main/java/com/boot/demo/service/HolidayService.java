package com.boot.demo.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

/**
 * @author CWZ
 */
@Service
public interface HolidayService {
    /*
    以下是历史查询--城市线网--节假日
     */

    public JSONObject getFlowByYear(Integer year);

    public JSONObject getAllLineHolidayAndWorkdayFlowByYear(Integer year);


    /*
    以下是历史查询--单线路详情--节假日
     */

   public JSONObject getDuanFLowByLine(Integer year, String line);


}

