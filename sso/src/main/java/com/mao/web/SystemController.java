package com.mao.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 基本页面，登录登出注册
 * @author zongx at 2020/3/29 15:06
 */
@Controller
public class SystemController implements ErrorController {

    private static final String ERROR = "error";

    @Override
    public String getErrorPath() {
        return ERROR;
    }

    @GetMapping("login")
    public String login(boolean error, HttpServletRequest request, Model model){
        String msg = "";
        if (error){
            Object exception = request.getSession()
                    .getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
            if (exception instanceof Exception)
                msg = ((Exception) exception).getMessage();
        }
        model.addAttribute("msg",msg);
        return "login";
    }

    @GetMapping({"index","/"})
    public String index(){
        return "index";
    }

}
