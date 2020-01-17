package com.xns.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: xns
 * @Date: 20-1-15 下午8:51
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptConsumer8011_APP {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer8011_APP.class,args);
    }
}
