package com.mushan.login.service.impl;

import com.mushan.exception.CodeException;
import com.mushan.exception.UserNamePassWordException;
import com.mushan.login.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    @Override
    public String login(Map<String, String> map) {
       String uuid =  map.containsKey("uuid")?map.get("uuid"):"";  // uuid
       String username =  map.containsKey("username")?map.get("username"):"";  // 用户名
       String password =  map.containsKey("password")?map.get("password"):"";  // 密码
       String code =  map.containsKey("code")?map.get("code"):""; // code

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            throw new UserNamePassWordException();
        }

        if (StringUtils.isEmpty(uuid) || StringUtils.isEmpty(code)){
            throw new CodeException();
        }

        /**
         * 验证 验证码
         */
        String captcha = redisTemplate.opsForValue().get("captcha" + uuid).toString();
        if (StringUtils.isEmpty(captcha)){
            throw new CodeException();
        }

        if (!code.equals(captcha)){
            throw new CodeException();
        }

        /*
         *  验证用户密码
         */



        return null;
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bcp = new BCryptPasswordEncoder();
        String encode = bcp.encode("123456");
        System.out.println(encode);

        System.out.println(bcp.matches("123456","$2a$10$8xSCf6BOCbK5HfOMyHL4feFPjKev72uyqLxXohuwNdWh6P2mE/w26"));

    }

}
