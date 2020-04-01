package com.mao.config.auth;

import com.mao.common.util.SU;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 定义oauth2请求匹配器
 * @author zongx at 2020/4/1 22:18
 */
@Component
public class KyOauth2RequestMatcher implements RequestMatcher {

    private static final String AUTHORIZATION = "Authorization";
    private static final String AUTHORIZATION_PRE = "Bearer";
    private static final String ACCESS_TOKEN_PARAM = "access_token";

    /**
     * 匹配规则
     * 判断请求是否包含oauth2授权信息
     * 授权信息来源包含头部的Authorization值并以Bearer开头
     * 或者请求参数中包含access_token参数
     * 满足其中一个表示匹配成功
     */
    @Override
    public boolean matches(HttpServletRequest request) {
        String auth = request.getHeader(AUTHORIZATION);
        boolean oauth2Token = SU.isNotEmpty(auth) && auth.startsWith(AUTHORIZATION_PRE);
        boolean accessToken = SU.isNotEmpty(request.getParameter(ACCESS_TOKEN_PARAM));
        return oauth2Token || accessToken;
    }

}
