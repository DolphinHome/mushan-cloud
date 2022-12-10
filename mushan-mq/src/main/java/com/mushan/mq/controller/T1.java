package com.mushan.mq.controller;

import com.mushan.common.security.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class T1 {


    @GetMapping("/taaa")
    @RequiresPermissions("aa:bb:vc")
    public void t1(){
        System.out.println("taaa");
    }

}
