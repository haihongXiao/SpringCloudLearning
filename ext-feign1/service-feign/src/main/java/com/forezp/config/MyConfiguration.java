package com.forezp.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义feign配置
 */
@Configuration
public class MyConfiguration {

    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }

}
