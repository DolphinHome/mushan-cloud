package com.mushan.gateway.filter;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Arrays;

/**
 * 网关鉴权
 * 
 * @author ruoyi
 */
@Component
public class AuthFilter implements GlobalFilter, Ordered
{

    private static final String[] URL_WHITELIST = {
            "/system/t2",
            "/user/login"
    };

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain)
    {
        //获取request
        ServerHttpRequest request = exchange.getRequest();
        //获取当前访问的路径
        String path = request.getURI().getPath();

        if (Arrays.asList(URL_WHITELIST).contains(path))
        {
            return chain.filter(exchange);
        }
        String token = request.getHeaders().getFirst("token");
        //开始判断是否存在token
        if (StringUtils.isEmpty(token)){
            throw new RuntimeException("权限不足，重新登录");
        }

        return chain.filter(exchange);
    }


    @Override
    public int getOrder() {
        return 0;
    }
}