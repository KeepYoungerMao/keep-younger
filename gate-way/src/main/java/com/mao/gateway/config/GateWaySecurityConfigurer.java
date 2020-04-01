package com.mao.gateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 网关安全配置
 * @author zongx at 2020/3/31 22:16
 */
@Configuration
@Order(90)
@EnableWebSecurity
public class GateWaySecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //api调用，禁用csrf
        http.csrf().disable();
    }
}
