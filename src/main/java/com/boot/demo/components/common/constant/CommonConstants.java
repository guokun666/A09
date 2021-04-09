package com.boot.demo.components.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * Created by ace on 2017/8/29.
 */
public class CommonConstants {
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
