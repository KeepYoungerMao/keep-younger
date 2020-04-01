package com.mao.gateway.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统信息请求
 * @author zongx at 2020/3/31 22:14
 */
@RestController
public class SystemController {

    @RequestMapping("/")
    public String index(){
        return "keep younger service gateway";
    }

}
