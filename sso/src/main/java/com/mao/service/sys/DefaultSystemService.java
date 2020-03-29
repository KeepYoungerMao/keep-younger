package com.mao.service.sys;

import com.mao.entity.sys.Client;
import com.mao.entity.sys.Permission;
import com.mao.entity.sys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 系统服务
 * @author zongx at 2020/3/29 14:39
 */
@Service
public class DefaultSystemService implements SystemService {

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User getUserByName(String name) {
        User user = new User();
        user.setId(1001L);
        user.setFull_name("张三");
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        user.setAuthorities(getAuthorities());
        user.setLocked(false);
        user.setEnabled(true);
        user.setExpired(false);
        return user;
    }

    private List<Permission> getAuthorities(){
        List<Permission> list = new ArrayList<>();
        Permission permission = new Permission();
        permission.setName("ROLE_ADMIN");
        list.add(permission);
        return list;
    }

    @Override
    public Client getClientById(String id) {
        Client c = new Client();
        c.setClientId(id);
        c.setClientSecret(passwordEncoder.encode("secret"));
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("READ"));
        authorities.add(new SimpleGrantedAuthority("WRITE"));
        c.setAuthorities(authorities);
        //授权类型
        Set<String> authorizedGrantTypes = new TreeSet<>();
        authorizedGrantTypes.add("authorization_code");
        authorizedGrantTypes.add("refresh_token");
        c.setAuthorizedGrantTypes(authorizedGrantTypes);
        Set<String> scope = new TreeSet<>();
        scope.add("all");
        c.setScope(scope);
        Set<String> redirectUri = new TreeSet<>();
        redirectUri.add("http://127.0.0.1:10000/login");
        c.setRegisteredRedirectUri(redirectUri);
        c.setAccessTokenValiditySeconds(7200);
        c.setRefreshTokenValiditySeconds(7200);
        return c;
    }

}
