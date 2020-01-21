package com.xns.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: xns
 * @Date: 20-1-16 上午8:38
 */
@SpringBootApplication
@EnableEurekaServer  //EurekaServer服务器端启动类，接受其他微服务注册进来。
public class Config_Git_EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(Config_Git_EurekaServerApplication.class,args);
    }
}
