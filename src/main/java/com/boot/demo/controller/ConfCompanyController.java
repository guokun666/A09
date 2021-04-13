package com.boot.demo.controller;

import com.boot.demo.bo.ConfCompanyBO;
import com.boot.demo.components.common.base.BasePage;
import com.boot.demo.components.common.base.BaseResult;
import com.boot.demo.vo.ConfCompanyVO;
import com.boot.demo.service.ConfCompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author A09服创团队
 * @email 317557750@qq.com
 * @date 2019-12-10 09:41:07
 */
@Slf4j
@RestController
@RequestMapping("/confCompany")
@Api("公司管理模块API文档")
public class ConfCompanyController {

    @Autowired
    private ConfCompanyService confCompanyService;

    
    /**
     * restful风格接口，get请求在后面拼接url地址
     * @return
     */

    @GetMapping("/{companyId}")
    public BaseResult<ConfCompanyVO> info(@PathVariable("companyId") String companyId) {
        ConfCompanyVO vo = confCompanyService.info(companyId);
        return BaseResult.ok(vo);
    }


    /**
     * 列表查询公司列表
     */
    @ApiOperation("查询公司列表")
    @PostMapping("/list")
    public BasePage<ConfCompanyVO> list(@RequestBody ConfCompanyBO confCompanyBO) {
        return confCompanyService.list(confCompanyBO);
    }

}
