package com.mao.entity.sys;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * 用户表
 * @author zongx at 2020/3/29 14:43
 */
@Getter
@Setter
public class User implements UserDetails {

    private Long id;                //主键
    private String full_name;       //姓名
    private String username;        //登录名
    private String password;        //密码
    private Boolean locked;         //是否锁定
    private Boolean expired;        //是否过期
    private Boolean enabled;        //是否正常使用

    private List<Permission> authorities;   //权限列表

    private Long role_id;           //用户角色id

    /*@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }*/

    @Override
    public boolean isAccountNonExpired() {
        return !expired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !expired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}
