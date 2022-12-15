package com.mushan.login.controller;

import com.mushan.login.service.LoginService;
import com.mushan.utlis.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;


    @PostMapping
    public Object login(@RequestBody Map<String,String> map){
        if (CollectionUtils.isEmpty(map)){
            return R.badArgument();
        }

        return R.ok(loginService.login(map));
    }

}
