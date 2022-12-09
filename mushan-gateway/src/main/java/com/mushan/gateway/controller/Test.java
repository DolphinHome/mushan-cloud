package com.mushan.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @Value("aa")
    private String aa;

    @GetMapping("/t1")
    public void t1(){
        System.out.println(aa);
    }

}
