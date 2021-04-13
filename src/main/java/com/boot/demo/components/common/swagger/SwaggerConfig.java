package com.boot.demo.components.common.swagger;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
//使用增强功能
@EnableSwaggerBootstrapUI
public class SwaggerConfig {



    /** 扫包根路径 **/
    //默认业务代码扫包路径
    private final String defaultPackage = "com.boot.demo";
    private final String defaultGroupName = "业务代码组";
    //自定义扫包路径(我定义了一个系统级别代码)
    private final String systemPackage= "com.boot.demo";
    private final String systemGroupName = "系统管理组";
    //标题
    private final String title = "A09服创管理系统";
    //描述
    private final String description = "A09服创管理系统";
    //termsOfServiceUrl
    private final String termsOfServiceUrl = "http://192.168.36.172:8888/";
    private final String version = "1.0";
    //消息体对象
    private final  String resp = "ResponseMsg";


    @Bean(value = "defaultApi")
    public Docket createRestApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
//                .groupName(defaultGroupName)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage(defaultPackage))
//                .paths(PathSelectors.regex("/api.*"))
//                .build();
//
                .apiInfo(apiInfo())
                .select()
                //为任何接口生成API文档
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
        return buildDefaultApi(docket);
    }

    @Bean(value = "systemApi")
    public Docket systemApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName(systemGroupName)
                .select()
                .apis(RequestHandlerSelectors.basePackage(systemPackage))
                .paths(PathSelectors.regex("/sys.*"))
                .build();
        return buildDefaultApi(docket);

    }

    /**
     * 默認配置
     * @param docket
     * @return
     */
    public Docket  buildDefaultApi(Docket docket){
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add(new ResponseMessageBuilder().code(404).message("找不到资源").responseModel(new ModelRef(resp)).build());
        responseMessageList.add(new ResponseMessageBuilder().code(400).message("参数校验异常").responseModel(new ModelRef(resp)).build());
        responseMessageList.add(new ResponseMessageBuilder().code(401).message("沒有登录成功/授权码过期").responseModel(new ModelRef(resp)).build());
        responseMessageList.add(new ResponseMessageBuilder().code(500).message("服务器内部错误").responseModel(new ModelRef(resp)).build());
        responseMessageList.add(new ResponseMessageBuilder().code(402).message("无效权限").responseModel(new ModelRef(resp)).build());

        docket.apiInfo(apiInfo())
                .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)
                .securityContexts(Lists.newArrayList(securityContext())).securitySchemes(Lists.<SecurityScheme>newArrayList(apiKey()));
        return docket;
    }


    /**
     * 登錄auto配置
     * @return
     */
    private ApiKey apiKey() {
        return new ApiKey("BearerToken", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }
    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("BearerToken", authorizationScopes));
    }

    /**
     * apiInfo
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(termsOfServiceUrl)
                .version(version)
                .contact("没猫饼有狗粮")
                .build();
    }

}
