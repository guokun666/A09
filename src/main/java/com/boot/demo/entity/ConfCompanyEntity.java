package com.boot.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author
 * @email manliyi@163.com
 * @date 2019-12-10 09:41:07
 * @Des 使用@Data注解就不用写GetSet方法了，Lombok会自动生成，对象.set()和对象.get()能直接使用
 */

@Data
public class ConfCompanyEntity {

    /**
     * 主键
     */
    private String companyId;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司类型id
     */
    private String companyTypeId;

    /**
     * 公司类型名称
     */
    private String companyTypeName;


    private String createUserid;

    private Date createTime;

    private Integer isDelete;

    private String updateUserid;

    private Date updateTime;

    private String remark;
}
