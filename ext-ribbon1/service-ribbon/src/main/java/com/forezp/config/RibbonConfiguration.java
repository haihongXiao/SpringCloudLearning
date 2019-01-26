package com.forezp.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定制ribbon Client
 * 该路径不能在@ComponentScan扫描的路径中
 */
@Configuration
public class RibbonConfiguration {
    /**
     * 第一次请求的时候才加载
     * @return
     */
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
