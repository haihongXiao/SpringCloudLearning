package com.forezp.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by fangzhipeng on 2017/4/6.
 * 使用自定义的FeignClient配置
 */
@FeignClient(value = "xxx",url = "http://localhost:8761/")
public interface SchedualServiceHi2 {
    @GetMapping("/eureka/apps/{serviceName}")
    String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
