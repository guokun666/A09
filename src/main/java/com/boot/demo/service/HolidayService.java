package com.boot.demo.service;

import com.boot.demo.entity.HolidayEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CWZ
 */
@Service
public interface HolidayService {
    /*
    以下是历史查询--城市线网--节假日
     */

    public List<HolidayEntity> getFlowByYear(Integer year);

    public List<HolidayEntity> getHolidayFlowByYear(Integer year);


    /*
    以下是历史查询--单线路详情--节假日
     */

   public List<HolidayEntity> getDuanFLowByLine(Integer year, String line);


}

