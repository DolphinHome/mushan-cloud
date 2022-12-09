package com.mushan.gateway.controller;

import com.mushan.common.security.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test1Controller {

    @GetMapping("/t2")
    @RequiresPermissions("aa:bb:vc")
    public void t2(){
        System.out.println("aabb");
    }

}
