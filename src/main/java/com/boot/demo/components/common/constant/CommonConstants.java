package com.boot.demo.components.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by ace on 2017/8/29.
 */
public class CommonConstants {
        //------------------------------------------
        public final static String[] LINE_NAME = {"1号线", "2号线", "3号线", "4号线", "5号线", "10号线", "11号线", "12号线"};
        public final static Integer LINE_NUMBERS = LINE_NAME.length;//线路数量
        public static Integer INDEX_OF_STRINGS(String[] list, String str){
            if(str==null)return -1;
            for(int i=0;i<list.length;i++)
                if(str.equals(list[i]))
                    return i;//返回对应线路所对应的索引号
            return -1;//不存在返回-1
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
