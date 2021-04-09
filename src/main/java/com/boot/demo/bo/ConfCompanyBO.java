package com.boot.demo.bo;

import com.boot.demo.components.common.base.BaseBO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 努力的码农
 * @email manliyi@163.com
 * @date 2019-12-10 09:41:07
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ConfCompanyBO extends BaseBO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String companyName;

    private String createUserId;

}
