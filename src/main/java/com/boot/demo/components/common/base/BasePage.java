package com.boot.demo.components.common.base;

import com.boot.demo.components.common.constant.CommonConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 努力的码农(Liiy)
 * @email manliyi@163.com
 * @date 2019/9/27 16:58
 */
@Data
@AllArgsConstructor
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class BasePage<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态编码
     */
    private int code = CommonConstants.HTTP_RES_CODE_200;

    /**
     * 状态消息
     */
    private String msg = CommonConstants.HTTP_RES_CODE_200_VALUE;

    private int total;

    private List<T> rows;

    public BasePage() {

    }

    public BasePage(long total, List<T> rows) {
        this(CommonConstants.HTTP_RES_CODE_200, CommonConstants.HTTP_RES_CODE_200_VALUE, (int) total, rows);
    }

//    public static BasePage PageToBasePage(Page page, List list) {
//        BasePage basePage = new BasePage();
//        basePage.setTotal((int) page.getTotal());
//        basePage.setRows(list);
//        return basePage;
//    }


    /**
     * @param dataSourceResList
     * @param <R>
     * @return
     */
    public <R> BasePage<R> convertPage(List<R> dataSourceResList) {
        return new BasePage<R>(total, dataSourceResList);
    }
}
