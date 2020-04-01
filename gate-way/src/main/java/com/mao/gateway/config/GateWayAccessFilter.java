package com.mao.gateway.config;

import com.mao.common.entity.response.ResponseData;
import com.mao.common.util.JsonUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 资源过滤器
 * 所有的资源请求在路由之前进行前置过滤
 * 如果请求头不包含 Authorization参数值，直接拦截不再路由
 * @author zongx at 2020/3/31 22:19
 */
public class GateWayAccessFilter extends ZuulFilter {

    private static final Logger log = LoggerFactory.getLogger(GateWayAccessFilter.class);
    private static final String FILTER_TYPE = "pre";
    private static final String AUTHORIZATION = "Authorization";

    /**
     * 过滤器类型
     * pre 表示请求在路由之前被过滤
     */
    @Override
    public String filterType() {
        return FILTER_TYPE;
    }

    /**
     * 执行顺序
     * 值越小越先执行
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行此过滤器
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器逻辑
     */
    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        String header = RequestContext.getCurrentContext().getRequest().getHeader(AUTHORIZATION);
        if (null == header){
            log.info("[ gateway ] [ failed ] Authorization is null.");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            context.setResponseBody(JsonUtil.obj2json(ResponseData.permission("Authorization is null")));
        }
        log.info("[ gateway ] [ access ] Authorization is ok.");
        return null;
    }
}
