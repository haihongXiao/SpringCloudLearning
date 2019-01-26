package com.forezp;

import com.netflix.appinfo.InstanceInfo;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}

	@Autowired
	EurekaClient eurekaClient;

	@Autowired
	DiscoveryClient discoveryClient;

	@Value("${server.port}")
	String port;
	@RequestMapping("/hi")
	public String home(@RequestParam String name) {
		return "hi "+name+",i am from port:" +port;
	}

	/**
	 * 查看请求调用的IP
	 * @return
	 */
	@RequestMapping("/eureka-instance")
	public String instanceUrl() {
		InstanceInfo info =  eurekaClient.getNextServerFromEureka("service-hi",false);
		return info.getHomePageUrl();
	}

	@RequestMapping("/instance-list")
	public List<ServiceInstance> instanceList() {
		List<ServiceInstance> list = discoveryClient.getInstances("service-hi");
		return list;
	}

	@RequestMapping("/instance-info")
	public ServiceInstance instanceInfo() {
		ServiceInstance info = discoveryClient.getLocalServiceInstance();
		return info;
	}
}
