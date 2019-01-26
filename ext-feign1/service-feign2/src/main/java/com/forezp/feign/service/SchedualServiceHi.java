package com.forezp.feign.service;

import com.forezp.config.MyConfiguration;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by fangzhipeng on 2017/4/6.
 * 使用自定义的FeignClient配置
 */
@FeignClient(value = "service-hi",configuration = MyConfiguration.class)
public interface SchedualServiceHi {
    @RequestLine("GET /hi")
    String sayHiFromClientOne(@Param("name") String name);
}
