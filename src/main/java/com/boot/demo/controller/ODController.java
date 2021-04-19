package com.boot.demo.controller;

import com.boot.demo.components.common.base.BaseResult;
import com.boot.demo.entity.ODEntity;
import com.boot.demo.service.ODService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.boot.demo.components.common.constant.CommonConstants.*;

@Slf4j
@RestController
@RequestMapping("/historyData/OD")
@Api(tags = "历史数据")
public class ODController {

    @Qualifier("ODServiceImpl")
    @Autowired
    private ODService odService;


    @GetMapping("/singleLine")
    @ApiOperation(value = "单线路-根据选择的日期显示OD报表", notes = "")
    public Object getOD(@RequestParam("day") String day,@RequestParam("line")Integer line) {
        List<ODEntity>entities = odService.getOD(day,line+"号线");
        if(entities==null)return BaseResult.ok(null);

        Integer lineIndex=INDEX_OF_STRINGS(LINE_ID,line);
        String[] STA=STATION_OF_LINES[lineIndex];

        List<List<Integer>>data=CREATE_LISTS(STA.length,STA.length,0);

        for(ODEntity e:entities){
//            System.out.println(e.getStart_station()+" "+INDEX_OF_STRINGS(STA,e.getStart_station())+" "
//                    +e.getEnd_station()+" "+INDEX_OF_STRINGS(STA,e.getEnd_station()));
            Integer index=INDEX_OF_STRINGS(STA,e.getEnd_station());
            if(index!=-1)
                data.get(INDEX_OF_STRINGS(STA,e.getStart_station()))
                    .set(index,e.getFlow());
        }

        return BaseResult.ok(TABLE_JSON(STA,STA,data));
    }




}

