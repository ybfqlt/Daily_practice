package com.xns.springcloud.controller;

import com.xns.springcloud.entities.Dept;
import com.xns.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: xns
 * @Date: 20-1-14 下午7:40
 */
@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }

    @RequestMapping(value="/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id){
        return deptService.get(id);
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return deptService.list();
    }

    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println("************"+list);

        List<ServiceInstance> serviceInstances = client.getInstances("SERVICECLOUD-DEPT");
        for(ServiceInstance serviceInstance:serviceInstances){
            System.out.println(serviceInstance.getServiceId()+"\t"+serviceInstance.getHost()+"\t"+serviceInstance.getPort()+"\t"+serviceInstance.getUri());
        }
        return this.client;
    }
}
