package com.boot.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author ricohgag
 * 2019/12/10
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConfCompanyVO {

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

}
