package com.forezp.ribbon;

import com.forezp.config.RibbonConfiguration;
import com.forezp.ribbon.config.MyComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

/**
 * 配置RibbonClient的时候需要注意name中的服务名为大写
 * 有待进一步测试
 */
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "SERVICE-HI", configuration = RibbonConfiguration.class)
//@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = MyComponentScan.class)})
public class ServiceRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRibbonApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}