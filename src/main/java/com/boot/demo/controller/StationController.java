package com.boot.demo.controller;

import com.boot.demo.service.StationService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author guokun
 * @email 317557750@qq.com
 * @date 2021-4-10
 */
@Slf4j
@RestController
@RequestMapping("/station")
@Api(tags = "A09")
public class StationController {

    @Autowired
    private StationService stationService;


    /**
     * restful风格接口，get请求在后面拼接url地址
     * @return
     */
    @GetMapping("/{stationId}")
    public Object getByStationId(@PathVariable("stationId") String stationId){
        return stationService.getByStationId(stationId);
    }


}
