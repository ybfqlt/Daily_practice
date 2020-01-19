package com.xns.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author: xns
 * @Date: 20-1-19 下午6:48
 */
@SpringBootApplication
@EnableZuulProxy
public class Zuul_9527_StartApp {
    public static void main(String[] args) {
        SpringApplication.run(Zuul_9527_StartApp.class, args);
    }
}
