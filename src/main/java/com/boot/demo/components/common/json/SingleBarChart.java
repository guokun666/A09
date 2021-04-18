package com.boot.demo.components.common.json;
//
//import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SingleBarChart {
    /**
     * line : ["0:0","0:15","0:30","0:45","1:0","1:15","1:30","1:45","2:0"]
     * series : [0,10,20,50,10,1,5,2,40]
     */
    public List<String> line;
    public List<Integer> series;

    public SingleBarChart(){
        line=new ArrayList<>();
        series=new ArrayList<>();
    }

    SingleBarChart(List<String> line,List<Integer> series){
        this.line=line;
        this.series=series;
    }

//    public static void main(String[] args) {
//        SingleBarChart a=new SingleBarChart();
//        a.line.add("sss");
//        JSONObject b=new JSONObject();
//        b.put("a",a);
//        System.out.println(b);
//    }
}
