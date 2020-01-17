package com.xns.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: xns
 * @Date: 20-1-14 下午7:49
 */
@SpringBootApplication
@EnableEurekaClient //本服务启动会自动注册进eureka服务中
@EnableDiscoveryClient   //服务发现
@MapperScan("com.xns.springcloud.dao")
public class DeptProvider8003_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8003_App.class,args);
    }
}
