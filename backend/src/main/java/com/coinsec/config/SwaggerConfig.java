package com.coinsec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

/**
 * Swagger配置
 * 
 * @author: kody
 * @since: 2025-9-13
 **/
@Configuration
public class SwaggerConfig {

    /**
     * 创建OpenAPI对象
     *
     * @return OpenAPI对象
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .openapi("3.1.0")
                .info(new Info()
                        .title("Coinsec 记账系统 API文档")
                        .description("基于Spring Boot的记账系统后端接口文档")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("kody")
                                .email("zj.wang.work@zohomail.cn")));
    }
}