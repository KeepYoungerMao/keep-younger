package com.mao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 开启服务发现，注册到注册中心
 * ：@EnableDiscoveryClient 和 @EnableEurekaClient 等价
 * 不同点在于：前者可以注册到其他注册中心，后者只能注册到Eureka
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApiApplication.class, args);
    }

}
