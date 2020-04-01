package com.mao.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * 基本页面，登录登出注册
 * @author zongx at 2020/3/29 15:06
 */
@RestController
@RequestMapping("user")
public class SystemController {

    @RequestMapping("base")
    public Principal user(Principal principal){
        return principal;
    }

}
