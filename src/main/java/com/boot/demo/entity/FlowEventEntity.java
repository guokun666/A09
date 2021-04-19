package com.boot.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "客流突发事件")
public class FlowEventEntity {
    @ApiModelProperty(allowEmptyValue=true,value = "事件号")
    private Integer eventNo;
    @ApiModelProperty(allowEmptyValue = true,value = "站点名称")
    private String stationName;
    @ApiModelProperty(required = true,allowEmptyValue = false,value = "事件发生时间")
    private String eventTime;
    @ApiModelProperty(required = true,allowEmptyValue = false,value = "事件类型")
    private String eventType;
    @ApiModelProperty(required = true,allowEmptyValue = false,value = "事件具体描述")
    private String eventDescription;
    @ApiModelProperty(allowEmptyValue = true,value = "事件是否被处理")
    private Integer isDone=0;

    public Integer getEventNo() {
        return eventNo;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Integer getDone() {
        return isDone;
    }

    public void setDone(Integer done) {
        isDone = done;
    }

    public void setEventNo(Integer eventNo) {
        this.eventNo = eventNo;
    }
}
