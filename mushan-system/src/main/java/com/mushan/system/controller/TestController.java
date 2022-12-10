package com.mushan.system.controller;

import com.mushan.common.security.annotation.RequiresPermissions;

import com.mushan.system.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/t1")
    @RequiresPermissions("aa:bb:vc")
    public void t1(){
        System.out.println("bbb");
    }

    @GetMapping("/t2")

    public void t2(){
        testService.t2();
    }




}
