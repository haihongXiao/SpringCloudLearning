package com.forezp.config;

import feign.Contract;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义feign配置
 */
@Configuration
public class MyConfiguration2 {
    /**
     * 访问Eureka需要账号密码的时候需要添加这个才可以访问到
     * @return
     */
//    @Bean
//    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
//        return new BasicAuthRequestInterceptor("user","admin");
//    }

}
