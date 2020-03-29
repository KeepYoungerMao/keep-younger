package com.mao.entity.sys;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 客户端
 * @author zongx at 2020/3/29 14:45
 */
@Getter
@Setter
public class Client implements ClientDetails {

    private String clientId;                            //客户端id
    private String clientSecret;                        //客户端secret
    private Set<String> resourceIds;                    //资源id
    private boolean secretRequired;                     //
    private boolean scoped;                             //
    private Set<String> scope;                          //
    private Set<String> authorizedGrantTypes;           //
    private Set<String> registeredRedirectUri;          //
    private List<GrantedAuthority> authorities;         //权限
    private Integer accessTokenValiditySeconds;         //token有效时间
    private Integer refreshTokenValiditySeconds;        //token刷新有效时间
    private Map<String, Object> additionalInformation;  //额外参数

    @Override
    public boolean isAutoApprove(String s) {
        return true;
    }

}
