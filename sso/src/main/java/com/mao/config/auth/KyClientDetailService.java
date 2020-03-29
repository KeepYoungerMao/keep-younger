package com.mao.config.auth;

import com.mao.entity.sys.Client;
import com.mao.service.sys.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

/**
 * spring security 客户端身份认证
 * 客户端查询方法
 * @author zongx at 2020/3/29 14:37
 */
@Component
public class KyClientDetailService implements ClientDetailsService {

    private SystemService systemService;

    @Autowired
    public void setSystemService(SystemService systemService){
        this.systemService = systemService;
    }

    /**
     * 根据client_id查询客户端
     * @param client_id client_id
     * @return 客户端
     * @throws ClientRegistrationException e
     */
    @Override
    public ClientDetails loadClientByClientId(String client_id) throws ClientRegistrationException {
        Client client = systemService.getClientById(client_id);
        if (null == client) throw new ClientRegistrationException("client not found");
        return client;
    }
}
