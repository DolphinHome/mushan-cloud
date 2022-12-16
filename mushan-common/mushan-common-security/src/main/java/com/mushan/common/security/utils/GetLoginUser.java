package com.mushan.common.security.utils;

import com.mushan.exception.AuthException;
import com.mushan.exception.TokenTimeOutException;
import com.mushan.utlis.JwtUtils;
import com.mushan.utlis.LoginUser;
import com.mushan.utlis.RequestUtlis;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

public class GetLoginUser {


    private static RedisTemplate redisTemplate;


    @Resource
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        GetLoginUser.redisTemplate = redisTemplate;
    }


    public static LoginUser getUser(){
        HttpServletRequest request = RequestUtlis.getRequest();
        String token = request.getHeader("mushan-token");   // 获取token
        if (StringUtils.isEmpty(token)){
            throw new  AuthException();
        }else {
            //解析token
            String uuid = JwtUtils.getUserNameFormToken(token);
            if (redisTemplate.hasKey("user" + uuid)) {
                return (LoginUser) redisTemplate.opsForValue().get("user" + uuid);
            } else {
                throw new TokenTimeOutException();
            }
        }
    }


}
