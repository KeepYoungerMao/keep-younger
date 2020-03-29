package com.mao.entity.sys;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author zongx at 2020/3/29 14:44
 */
@Getter
@Setter
public class Permission implements GrantedAuthority {

    private Long id;
    private String name;
    private String intro;

    @Override
    public String getAuthority() {
        return name;
    }

}
