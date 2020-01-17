package com.xns.springcloud.cfgbean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: xns
 * @Date: 20-1-15 下午7:33
 */
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced  //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端负载均衡的工具
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
