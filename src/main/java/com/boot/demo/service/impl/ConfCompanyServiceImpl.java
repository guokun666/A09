package com.boot.demo.service.impl;

import com.boot.demo.bo.ConfCompanyBO;
import com.boot.demo.components.common.base.BasePage;
import com.boot.demo.dao.ConfCompanyDao;
import com.boot.demo.entity.ConfCompanyEntity;
import com.boot.demo.service.ConfCompanyService;
import com.boot.demo.vo.ConfCompanyVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ricohgag
 */
@Slf4j
@Service
public class ConfCompanyServiceImpl implements ConfCompanyService {
    @Autowired
    private ConfCompanyDao confCompanyDao;

    @Override
    public BasePage<ConfCompanyVO> list(ConfCompanyBO confCompanyBO) {
        List<ConfCompanyEntity> confCompanyEntities = confCompanyDao.selectByWhere(confCompanyBO);

        List<ConfCompanyVO> confCompanyVOList = new ArrayList<>();
        for (ConfCompanyEntity entity : confCompanyEntities) {
            ConfCompanyVO vo = new ConfCompanyVO();
            vo.setCompanyId(entity.getCompanyId());
            vo.setCompanyName(entity.getCompanyName());
            vo.setCompanyTypeId(entity.getCompanyTypeId());
            vo.setCompanyTypeName(entity.getCompanyTypeName());
            confCompanyVOList.add(vo);
        }
        
        long count = confCompanyDao.countByWhere(confCompanyBO);
        return new BasePage<>(count, confCompanyVOList);
    }


    @Override
    public ConfCompanyVO info(String companyId) {
        ConfCompanyEntity entity = confCompanyDao.getByCompanyId(companyId);
        ConfCompanyVO vo = new ConfCompanyVO();
        vo.setCompanyId(entity.getCompanyId());
        vo.setCompanyName(entity.getCompanyName());
        vo.setCompanyTypeId(entity.getCompanyTypeId());
        vo.setCompanyTypeName(entity.getCompanyTypeName());
        return vo;
    }
}

