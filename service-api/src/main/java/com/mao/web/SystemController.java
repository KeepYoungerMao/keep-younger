package com.mao.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zongx at 2020/4/1 23:01
 */
@RestController
@RequestMapping("api")
public class SystemController {

    @RequestMapping("test1")
    public String test1(){
        return "test is ok";
    }

    @RequestMapping("test")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public String test2(String name){
        return "test2 is ok : "+name;
    }

}
