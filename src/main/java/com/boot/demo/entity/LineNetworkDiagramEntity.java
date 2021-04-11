package com.boot.demo.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;


@Data
public class LineNetworkDiagramEntity {

    private String text="Sta1";//信息
    private String shape="circle";//形状
    private int[] size={8,8};//大小
    private String labelColor="#000";//标签颜色（黑色）
    private String labelPosition="bottom";//标签位置（下方）
    private int[] position={0,0};//坐标位置值
    private String internalColor="#fff";//内部颜色（白色）
    private String borderCorlor="#10069f";//边框颜色
    private int borderWidth=2;//边框宽度
    private int rotate=0;//旋转角度

//    public static void main(String[] args) {
//        LineNetworkDiagramEntity lineNetworkDiagramEntity=new LineNetworkDiagramEntity();
//        System.out.println(lineNetworkDiagramEntity.getStationJson());
//    }

    //设置线路标题信息
    public void setLineTitleInformation(String lineName,int x,int y,String labelColor){
        this.text=lineName;
        this.position[0]=x;
        this.position[1]=y;
        this.labelColor=labelColor;
    }

    //获取线路标题json串
    public JSONObject getLineTitleJson(){
        JSONObject json=new JSONObject();

        json.put("name",text);
        json.put("symbolSize",0.1);
        json.put("value",position);

        JSONObject tooltipJson=new JSONObject();
        tooltipJson.put("show",false);//将图形体隐藏不显示
        json.put("tooltip",tooltipJson);

        JSONObject labelJson=new JSONObject();
        labelJson.put("color",labelColor);
        labelJson.put("fontSize",14);//标签字体大小 默认14
        json.put("itemStyle",labelJson);

        return json;
    }

    //设置站点信息
    public void setStationInformation(String staName,int size,int x,int y,String labelPosition,String internalColor,String borderColor){
        this.text=staName;
        this.size[0]=this.size[1]=size;
        this.position[0]=x;
        this.position[1]=y;
        this.labelPosition=labelPosition;
        this.internalColor=internalColor;
        this.borderCorlor=borderColor;
    }

    //获取站点json串
    public JSONObject getStationJson(){
        JSONObject json=new JSONObject();

        json.put("name",text);
        json.put("symbol","circle");//站点显示成圆
        json.put("symbolSize",size);
        json.put("value",position);

        JSONObject labelJson=new JSONObject();
        labelJson.put("color","#000");//站点标签字体设置黑色
        labelJson.put("position",labelPosition);
        json.put("label",labelJson);

        JSONObject itemStyleJson=new JSONObject();
        JSONObject normalJson=new JSONObject();
        normalJson.put("color",internalColor);
        normalJson.put("borderColor",borderCorlor);
        normalJson.put("borderWidth",2);//站点外边框大小默认2
        itemStyleJson.put("normal",normalJson);
        json.put("itemStyle",itemStyleJson);

        return json;
    }

    //设置列车信息
    public void setTrainInformation(int x,int y,int rotate,String nextStation,int weight){
        this.position[0]=x;
        this.position[1]=y;
        this.rotate=rotate;
        this.text="function(e){return '下一到站点: "+nextStation+" 载重数: "+weight+"kg';}";
    }

    //获取列车json串
    public JSONObject getTrainJson(){
        JSONObject json=new JSONObject();

        json.put("xAxis",position[0]);
        json.put("yAxis",position[1]);
        json.put("symbolSize",20);//图标大小
        json.put("symbolRotate",rotate);

        JSONObject tooltipJson=new JSONObject();
        //由于默认会显示就不需要了 tooltipJson.put("show",true);//显示图标
        tooltipJson.put("formatter",text);//显示的提示函数文本
        tooltipJson.put("triggerOn","click");//当点击的时候显示提示文本
        json.put("tooltip",tooltipJson);

        JSONObject itemStyleJson=new JSONObject();
        JSONObject normalJson=new JSONObject();
        normalJson.put("color","#060376");//内部颜色 默认填充#060376
        //normalJson.put("borderColor",borderCorlor);
        //normalJson.put("borderWidth",2);//站点外边框大小默认2
        itemStyleJson.put("normal",normalJson);
        json.put("itemStyle",itemStyleJson);

        return json;
    }

}
