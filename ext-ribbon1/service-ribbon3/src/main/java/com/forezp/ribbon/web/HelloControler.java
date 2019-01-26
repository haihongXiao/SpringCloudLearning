package com.forezp.ribbon.web;

import com.forezp.ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fangzhipeng on 2017/4/6.
 */
@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }

    @RequestMapping(value = "/balancer")
    public String balancerClient(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("SERVICE-HI");
        System.out.println(serviceInstance.getHost() + ":" + serviceInstance.getPort() + ":" + serviceInstance.getServiceId());
        return "balancer";
    }

}
