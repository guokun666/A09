package com.boot.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.dao.LineNetworkDiagramDao;
import com.boot.demo.entity.LineNetworkDiagramEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * @author guokun
 * @email 317557750@qq.com
 * @date 2021-4-10
 */
@Slf4j
@ResponseBody
@RestController
@RequestMapping("/LineNetworkDiagram")
@Api(tags = "线网图")
public class LineNetworkDiagramController {

    @Autowired
    private LineNetworkDiagramDao lineNetworkDiagramDao;

    @ApiOperation(
            value = "获取整体线网图的数据",
            notes = "修改时间：2020-4-13\n" +
                    "返回的数据只有一组数据：Data[]\n" +
                    "（线路标题 和 站点信息）\n" +
                    "我们决定不在整体线网图中显示列车信息，所以不会返回markPoint[]\n" +
                    "link[]为固定信息，因此不再返回" )
    @GetMapping("/networkDiagram")
    public Object getNetworkDiagram(){
        List<JSONObject> jsons = new ArrayList<JSONObject>();

        //先获取 线路标题信息
        List<LineNetworkDiagramEntity> lineTitles = lineNetworkDiagramDao.getStationInformation();
        //转换成json串
        for(LineNetworkDiagramEntity lineTitle:lineTitles){
            jsons.add(lineTitle.getLineTitleJson());
        }

        //再获取 站点信息
        List<LineNetworkDiagramEntity> stations = lineNetworkDiagramDao.getLineTitleInformation();
        //转换成json串
        for(LineNetworkDiagramEntity station:stations){
            jsons.add(station.getStationJson());
        }

        return jsons;
    }



}
