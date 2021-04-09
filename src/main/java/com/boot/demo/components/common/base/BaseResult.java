package com.boot.demo.components.common.base;

import com.boot.demo.components.common.constant.CommonConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author
 * @email manliyi@163.com
 * @date 2019/9/27 16:37
 * @Des 用于返回给前端统一的对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResult<T> implements Serializable {

    private static final long serialVersionUID = 3220456690316130103L;

    /**
     * 状态编码
     */
    private int code;

    /**
     * 状态消息
     */
    private String msg;

    /**
     * 数据体
     */
    public T data;


    public static BaseResult error() {
        return error(CommonConstants.EX_OTHER_CODE, CommonConstants.HTTP_RES_CODE_500_VALUE);
    }


    public static BaseResult error(String msg) {
        return error(CommonConstants.EX_OTHER_CODE, msg);
    }


    public static BaseResult error(int code, String msg) {
        return new BaseResult(code, msg,null);
    }


    public static BaseResult ok() {
        return ok(CommonConstants.HTTP_RES_CODE_200, CommonConstants.HTTP_RES_CODE_200_VALUE,"");
    }


    public static <T> BaseResult<T> ok(T data) {
        return ok(CommonConstants.HTTP_RES_CODE_200, CommonConstants.HTTP_RES_CODE_200_VALUE,data);
    }


    public static <T> BaseResult<T> ok(int code, String msg,Object data) {
        return new BaseResult(code, msg,data);
    }



}
