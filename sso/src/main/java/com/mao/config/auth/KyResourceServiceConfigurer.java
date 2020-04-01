package com.mao.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * 资源服务器配置
 * @author zongx at 2020/3/29 14:57
 */
@Configuration
@EnableResourceServer
public class KyResourceServiceConfigurer extends ResourceServerConfigurerAdapter {

    private KyOauth2RequestMatcher kyOauth2RequestMatcher;

    @Autowired
    public void setKyOauth2RequestMatcher(KyOauth2RequestMatcher kyOauth2RequestMatcher){
        this.kyOauth2RequestMatcher = kyOauth2RequestMatcher;
    }

    /**
     * 安全配置
     * 采用自定义请求匹配器进行匹配
     * 放行OPTION请求
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatcher(kyOauth2RequestMatcher)
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS)
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);
    }

}
