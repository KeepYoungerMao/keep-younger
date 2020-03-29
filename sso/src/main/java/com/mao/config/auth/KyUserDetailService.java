package com.mao.config.auth;

import com.mao.entity.sys.User;
import com.mao.service.sys.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * spring security 用户身份认证
 * 用户查询方法
 * @author zongx at 2020/3/29 14:53
 */
@Component
public class KyUserDetailService implements UserDetailsService {

    private SystemService systemService;

    @Autowired
    public void setSystemService(SystemService systemService){
        this.systemService = systemService;
    }

    /**
     * 查询用户
     * @param username 用户登录名
     * @return 用户
     * @throws UsernameNotFoundException e
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = systemService.getUserByName(username);
        if (null == user) throw new UsernameNotFoundException("cannot load user by "+username);
        return user;
    }
}
