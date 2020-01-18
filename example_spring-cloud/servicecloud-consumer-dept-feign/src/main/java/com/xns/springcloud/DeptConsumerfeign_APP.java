package com.xns.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: xns
 * @Date: 20-1-15 下午8:51
 */
//@ComponentScan("com.xns.springcloud")
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.xns.springcloud"})
public class DeptConsumerfeign_APP {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerfeign_APP.class,args);
    }
}
