package com.mao.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * EnableDiscoveryClient： 开启服务发现
 * EnableOAuth2Sso：启用oauth2单点登录
 * EnableZuulProxy：启用网关路由
 */
@SpringBootApplication
@EnableOAuth2Sso
@EnableZuulProxy
public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }

}
