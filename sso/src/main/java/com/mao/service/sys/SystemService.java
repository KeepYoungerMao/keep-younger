package com.mao.service.sys;

import com.mao.entity.sys.Client;
import com.mao.entity.sys.User;

/**
 * 系统服务
 * @author zongx at 2020/3/29 14:39
 */
public interface SystemService {

    /**
     * 根据用户登录名查询用户
     * @param name 登录名
     * @return 用户
     */
    User getUserByName(String name);

    /**
     * 根据客户端id查询客户端
     * @param id client_id
     * @return 客户端
     */
    Client getClientById(String id);

}
