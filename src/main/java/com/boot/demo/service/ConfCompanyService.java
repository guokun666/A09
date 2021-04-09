package com.boot.demo.service;

import com.boot.demo.bo.ConfCompanyBO;
import com.boot.demo.components.common.base.BasePage;
import com.boot.demo.dao.ConfCompanyDao;
import com.boot.demo.entity.ConfCompanyEntity;
import com.boot.demo.vo.ConfCompanyVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ricohgag
 */
@Service
public interface ConfCompanyService {

    /**
     * 通过条件分页查询公司列表
     * @param confCompanyBO
     * @return
     */
    BasePage<ConfCompanyVO> list(ConfCompanyBO confCompanyBO);

    ConfCompanyVO info(String companyId);

}

