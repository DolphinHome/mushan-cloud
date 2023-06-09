package com.mushan.system.controller;

import com.mushan.common.security.utils.GetLoginUser;
import com.mushan.system.service.LoginService;
import com.mushan.utlis.LoginUser;
import com.mushan.utlis.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;


    @PostMapping
    public Object login(@RequestBody Map<String,String> map){
        //登录
        if (CollectionUtils.isEmpty(map)){
            //判断如果为空
            return R.badArgument();
        }
        return R.ok(loginService.login(map));
    }


    @GetMapping
    public Object getlogin(){
        LoginUser user = GetLoginUser.getUser();
        return R.ok(user);
    }

}
