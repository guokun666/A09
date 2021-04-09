package com.boot.demo.dao;


import com.boot.demo.bo.ConfCompanyBO;
import com.boot.demo.entity.ConfCompanyEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 努力的码农
 * @email manliyi@163.com
 * @date 2019-12-10 09:41:07
 */
@Repository
public interface ConfCompanyDao {


    /**
     * 获取分页查询总数
     * @param confCompanyBO
     * @return
     */
    long countByWhere(ConfCompanyBO confCompanyBO);

    /**
     * 根据条件查询列表
     * @param confCompanyBO
     * @return
     */
    List<ConfCompanyEntity> selectByWhere(ConfCompanyBO confCompanyBO);

    /**
     * 通过公司查询单条公司接口
     * @param companyId
     * @return
     */
    ConfCompanyEntity getByCompanyId(@Param("companyId") String companyId);

}
