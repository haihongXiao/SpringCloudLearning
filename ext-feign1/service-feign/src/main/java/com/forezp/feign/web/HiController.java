package com.forezp.feign.web;

import com.forezp.feign.service.SchedualServiceHi;
import com.forezp.feign.service.SchedualServiceHi2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by fangzhipeng on 2017/4/6.
 */
@RestController
public class HiController {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @Autowired
    SchedualServiceHi2 schedualServiceHi2;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return schedualServiceHi.sayHiFromClientOne(name);
    }

    @GetMapping("/{serviceName}")
    String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName){
        return schedualServiceHi2.findServiceInfoFromEurekaByServiceName(serviceName);
    }
}
