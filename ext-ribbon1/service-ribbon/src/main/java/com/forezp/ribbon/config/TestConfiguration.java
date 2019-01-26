package com.forezp.ribbon.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定制ribbon Client
 * 当该配置在@ComponentScan扫描的路径中
 * 1. 需要添加自定义的@MyComponentScan注解，
 * 2. @ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = MyComponentScan.class)})
 */
@Configuration
@MyComponentScan
public class TestConfiguration {
    /**
     * 第一次请求的时候才加载
     * @return
     */
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
