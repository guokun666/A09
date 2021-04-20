package com.boot.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.components.common.base.BaseResult;
import com.boot.demo.service.LineNetworkDiagramService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;



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
    private LineNetworkDiagramService lineNetworkDiagramService;

    @ApiOperation(
            value = "获取整体线网图的数据",
            notes = "修改时间：2020-4-13\n" +
                    "这里需要两个参数：起始时间戳 终止时间戳(BigInteger)" +
                    "如果不传参数也可以，目前是返回固定内容" +
                    "返回的数据只有一组数据：Data[]\n" +
                    "（线路标题 和 站点信息）\n" +
                    "我们决定不在整体线网图中显示列车信息，所以不会返回markPoint[]\n" +
                    "link[]为固定信息，因此不再返回" )
    @GetMapping("/cityNetworkDiagram")
    public Object getCityNetworkDiagram(@RequestParam(value = "startTime",required = false)BigInteger startTime,
                                        @RequestParam(value = "endTime",required = false)BigInteger endTime){
        return BaseResult.ok(lineNetworkDiagramService.getCityInformation());
    }

    @ApiOperation(
            value = "[实时]整体线网图的数据")
    @GetMapping("/realTimeCityNetworkDiagram")
    public Object getRealTimeCityNetworkDiagram(){
        return BaseResult.ok(lineNetworkDiagramService.getCityInformation());
    }

    @ApiOperation(
            value = "单线路-线网图的数据")
    @GetMapping("/lineNetworkDiagram")
    public Object getLineNetworkDiagram(@RequestParam(value = "startTime",required = false)BigInteger startTime,
                                        @RequestParam(value = "endTime",required = false)BigInteger endTime,
                                        @RequestParam("lineID")Integer lineID){
        String line=lineID+"号线";
        return BaseResult.ok(lineNetworkDiagramService.getLineStationInformation(line));
    }

    @ApiOperation(
            value = "单线路-[实时]线网图的数据")
    @GetMapping("/realTimeLineNetworkDiagram")
    public Object getRealTimeLineNetworkDiagram(@RequestParam("lineID")Integer lineID){
        String line=lineID+"号线";
        JSONObject json=new JSONObject(true);

        json.put("data",lineNetworkDiagramService.getLineStationInformation(line));
        json.put("markPoint",lineNetworkDiagramService.getLineTrainInformation(line));

        return BaseResult.ok(json);
    }
}
