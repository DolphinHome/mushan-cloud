package com.mushan.gateway.filter;



import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.common.model.RestResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mushan.exception.AuthException;
import com.mushan.utlis.R;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Arrays;

/**
 * 网关鉴权
 *
 */
@Component
public class AuthFilter implements GlobalFilter, Ordered
{

    private static final String[] URL_WHITELIST = {
            "/system/captchaImage",
            "/system/login"

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
        String token = request.getHeaders().getFirst("mushan-token");
        //开始判断是否存在token
        if (StringUtils.isEmpty(token)){
            //返回状态
            return writer(exchange.getResponse());
        }
        return chain.filter(exchange);
    }

    private Mono<Void> writer(ServerHttpResponse response){
        response.setStatusCode(HttpStatus.OK);  //状态吗
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);  //返回数据格式
        DataBuffer dataBuffer = response.bufferFactory().wrap(JSON.toJSONString(R.unauthz()).getBytes());
        return response.writeWith(Mono.just(dataBuffer));
    }


    @Override
    public int getOrder() {
        return 0;
    }
}