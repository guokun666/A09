package com.boot.demo.components.common.constant;


import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ace on 2017/8/29.
 */
public class CommonConstants {
        //------------------------------------------


        public final static String[] LINE_NAME = {"1号线", "2号线", "3号线", "4号线", "5号线", "10号线", "11号线", "12号线"};
        public final static Integer[] LINE_ID = {1, 2, 3, 4, 5, 10, 11, 12};
        public final static String[] MONTH = {"1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"};
        //        public final static String[] HOLIDAY ={"元旦","春节","清明","五一","端午"};
        public final static Integer LINE_NUMBERS = LINE_NAME.length;//线路数量


    //图标展示要用到的json-----------------------------


    public static <N,V,T,M> List<JSONObject> TWO_JSON_LIST(T key1, List<N> name, M key2, List<V> value){
        List<JSONObject>cards=new ArrayList<>();
        for(int i=0;i<name.size();i++){
            JSONObject js=new JSONObject(true);
            js.put("name",name.get(i));
            js.put("value",value.get(i));
            cards.add(js);
        }
        return cards;
    }

    public static <N,V> JSONObject CARD_CHART_JSON(N[] name,V[] value){
        JSONObject cardChart=new JSONObject(true);
        List<JSONObject>cards=new ArrayList<>();
        for(int i=0;i<name.length;i++){
            JSONObject js=new JSONObject(true);
            js.put("name",name[i]);
            js.put("value",value[i]);
            cards.add(js);
        }
        cardChart.put("cardChart",cards);
        return cardChart;
    }

    public static <T,P> JSONObject CHART_JSON(P[] axisName,List<T> series){
        JSONObject json=new JSONObject(true);
        json.put("line",axisName);
        json.put("series",series);
        return json;
    }

    public static <T,P,M> JSONObject SERIES_JSON(P name,M type,List<T>data){
        JSONObject json=new JSONObject(true);
        json.put("name",name);
        json.put("type",type);
        json.put("data",data);
//        System.out.println(data);
        return json;
    }

    public static <T,P,M> List<Object> SERIES_LIST(P[] names,M type,List<List<T>>data){
        List<Object>series=new ArrayList<>();
        for(int i=0;i<names.length;i++){
            series.add(SERIES_JSON(names[i],type,data.get(i)));
        }
        return series;
    }

    public static <T> List<List<T>> CREATE_LISTS(int listsLen, int listLen,T t){
        List<List<T>>lists=new ArrayList<>();
        for(int i=0;i<listsLen;i++){
            List<T>list=new ArrayList<>();
            for(int j=0;j<listLen;j++)list.add(t);
            lists.add(list);
        }
        return lists;
    }


    //----------------------------------------------
        public static int DAYS_OF_MONTH_IN_YEAR(int year,int month){
            Calendar calendar = Calendar.getInstance();
            calendar.set(year,month-1,1);
            return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        }

        public  static  Integer[] INIT_FROM_1_TO_END(Integer[] ts){
            for(int i=1;i<=ts.length;i++)ts[i-1]=i;
            return ts;
        }

        //生成[A,B]的数组（左右都是包含）
    public  static  Integer[] INIT_FROM_A_TO_B(int A,int B){
        Integer[] ans=new Integer[B-A+1];
        for(int i=A;i<=B;i++)ans[i-A]=i;
        return ans;
    }


    public static <T> T[] INIT_BY(T[] ts,T t){
            for (int i=0;i<ts.length;i++)ts[i]=t;
            return ts;
        }

        public static <T> String[] ADD_TO_STRING(T[] t,String addString){
            String[] strings=new String[t.length];
            for(int i=0;i<t.length;i++)strings[i]=t[i]+addString;
            return strings;
        }

        public static <T> Integer INDEX_OF_STRINGS(T[] list, T str){
            if(str==null)return -1;
            for(int i=0;i<list.length;i++)
                if(str.equals(list[i]))
                    return i;//返回对应字符串所对应的索引号
            return -1;//不存在返回-1
        }

        public static <T> Integer INDEX_OF_LIST(List<T> list, T it){
            if(it==null)return -1;
            for(int i=0;i<list.size();i++)
                if(it.equals(list.get(i)))
                    return i;//返回对应元素所对应的索引号
            return -1;//不存在返回-1
        }

        //获取字符串中第一串数字的值
        public static Integer STRING_TO_INT(String s){
            int begin=-1,end=-1;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)>'0'&&s.charAt(i)<'9'){
                    if(begin==-1)begin=i;
                    end=i;
                }else if(end!=-1)break;
            }
            if(begin==-1||end==-1)return -1;
            return Integer.parseInt(s.substring(begin,end+1));
        }

    public final static String[] STATION_OF_LINE_1={
            "Sta104",
            "Sta65",
            "Sta49",
            "Sta149",
            "Sta74",
            "Sta128",
            "Sta34",
            "Sta106",
            "Sta110",
            "Sta97",
            "Sta80",
            "Sta89",
            "Sta64",
            "Sta150",
            "Sta154",
            "Sta107",
            "Sta83",
            "Sta108",
            "Sta159",
            "Sta1"
        };
    public final static String[] STATION_OF_LINE_2={
            "Sta51",
            "Sta105",
            "Sta24",
            "Sta139",
            "Sta71",
            "Sta57",
            "Sta76",
            "Sta52",
            "Sta68",
            "Sta151",
            "Sta48",
            "Sta27",
            "Sta81",
            "Sta127",
            "Sta123",
            "Sta47",
            "Sta18",
            "Sta79",
            "Sta78",
            "Sta53",
            "Sta163",
            "Sta9",
            "Sta129"
    };
    public final static String[] STATION_OF_LINE_3={
            "Sta155",
            "Sta143",
            "Sta156",
            "Sta61",
            "Sta50",
            "Sta119",
            "Sta66",
            "Sta12",
            "Sta161",
            "Sta21",
            "Sta133",
            "Sta22",
            "Sta138",
            "Sta41",
            "Sta30",
            "Sta67",
            "Sta144",
            "Sta5",
            "Sta98",
            "Sta29",
            "Sta126",
            "Sta40",
            "Sta131",
            "Sta39",
            "Sta100",
            "Sta167",
            "Sta113",
            "Sta141",
            "Sta142",
            "Sta158",
            "Sta44",
            "Sta117",
            "Sta147",
            "Sta42",
            "Sta35",
            "Sta109",
            "Sta33",
            "Sta112",
            "Sta153",
            "Sta125",
            "Sta121",
            "Sta11"
    };
    public final static String[] STATION_OF_LINE_4={
            "Sta84",
            "Sta59",
            "Sta19",
            "Sta62",
            "Sta165",
            "Sta58",
            "Sta38"
    };
    public final static String[] STATION_OF_LINE_5={
            "Sta54",
            "Sta69",
            "Sta16",
            "Sta37",
            "Sta132",
            "Sta96",
            "Sta10",
            "Sta43"
    };
    public final static String[] STATION_OF_LINE_10={
            "Sta157",
            "Sta114",
            "Sta168",
            "Sta135",
            "Sta134",
            "Sta85",
            "Sta2",
            "Sta4",
            "Sta103",
            "Sta145",
            "Sta88",
            "Sta87",
            "Sta94",
            "Sta160",
            "Sta7",
            "Sta6",
            "Sta8",
            "Sta75",
            "Sta102"
    };
    public final static String[] STATION_OF_LINE_11={
            "Sta28",
            "Sta124",
            "Sta99",
            "Sta166",
            "Sta36",
            "Sta122",
            "Sta77",
            "Sta140",
            "Sta111",
            "Sta13",
            "Sta70",
            "Sta55",
            "Sta20",
            "Sta23",
            "Sta56",
            "Sta118",
            "Sta115",
            "Sta162",
            "Sta15",
            "Sta86",
            "Sta46",
            "Sta63",
            "Sta3",
            "Sta25",
            "Sta146",
            "Sta130",
            "Sta120",
            "Sta82",
            "Sta164",
            "Sta152",
            "Sta45"
    };
    public final static String[] STATION_OF_LINE_12={
            "Sta14",
            "Sta73",
            "Sta148",
            "Sta60",
            "Sta91",
            "Sta32",
            "Sta116",
            "Sta92",
            "Sta31",
            "Sta93",
            "Sta72",
            "Sta95",
            "Sta90",
            "Sta26",
            "Sta17",
            "Sta101",
            "Sta136",
            "Sta137"
    };

    public final static String[][] STATION_OF_LINES={
            STATION_OF_LINE_1,
            STATION_OF_LINE_2,
            STATION_OF_LINE_3,
            STATION_OF_LINE_4,
            STATION_OF_LINE_5,
            STATION_OF_LINE_10,
            STATION_OF_LINE_11,
            STATION_OF_LINE_12
    };
    //-------------------------------------------
        public final static String RESOURCE_TYPE_MENU = "menu";
        public final static String RESOURCE_TYPE_BTN = "button";
        // 用户token异常
        public static final Integer EX_USER_INVALID_CODE = 40101;
        public static final Integer EX_USER_PASS_INVALID_CODE = 40001;
        // 客户端token异常
        public static final Integer EX_CLIENT_INVALID_CODE = 40301;
        public static final Integer EX_CLIENT_FORBIDDEN_CODE = 40331;
        /**
         * 响应请求成功
         */
        public static final String HTTP_RES_CODE_200_VALUE = "success";

        /**
         * 系统错误
         */
        public static final String HTTP_RES_CODE_500_VALUE = "fail";

        /**
         * 响应请求成功code
         */
        public static final int HTTP_RES_CODE_200 = 200;
        public static final int EX_OTHER_CODE = 500;
        public static final String CONTEXT_KEY_USER_ID = "currentUserId";
        public static final String CONTEXT_KEY_USERNAME = "currentUserName";
        public static final String CONTEXT_KEY_USER_NAME = "currentUser";
        public static final String CONTEXT_KEY_USER_TOKEN = "currentUserToken";
        public static final String JWT_KEY_USER_ID = "userId";
        public static final String JWT_KEY_NAME = "name";
        public static final String CONTEXT_KEY_ORG_ID = "currentOrgId";
        public static final String CONTEXT_KEY_DEPT_ID = "currentDeptId";

        public enum AutoSaveParam {
            //ID自增ID, BID机构ID, CREATED_NAME创建用户名, CREATED_BY创建人, CREATED_TIME创建时间
            ID, ORG_ID, DEPT_ID, CREATED_NAME, CREATED_BY,
            CREATED_TIME, IS_DELETE, UPDATED_NAME, UPDATED_BY, UPDATED_TIME,
            ;
        }

        public enum AutoSaveType {
            /**
             * 创建
             */
            CREATE,
            /**
             * 修改
             */
            UPDATE,
            ;
        }

        @AllArgsConstructor
        @Getter()
        @Accessors(fluent = true)
        public enum LogicDeleteStatus {

            /**
             * 存在
             */
            EXITS(0),
            /**
             * 删除
             */
            DELETE(1),
            ;

            private int status;
        }

}
