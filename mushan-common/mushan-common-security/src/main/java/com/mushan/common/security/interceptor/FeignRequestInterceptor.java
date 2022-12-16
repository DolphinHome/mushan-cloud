package com.mushan.common.security.interceptor;

import com.mushan.utlis.RequestUtlis;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sun.security.util.SecurityConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;
import java.util.Objects;

@Configuration
public class FeignRequestInterceptor implements RequestInterceptor
{
    @Override
    public void apply(RequestTemplate requestTemplate)
    {
        HttpServletRequest request = RequestUtlis.getRequest();
        if (request != null){
            String token = request.getHeader("mushan-token");
            requestTemplate.header("mushan-token",token);
        }
    }
}