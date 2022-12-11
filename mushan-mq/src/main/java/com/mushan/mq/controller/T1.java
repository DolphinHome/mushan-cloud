package com.mushan.mq.controller;

import com.mushan.common.log.annotation.Log;
import com.mushan.common.security.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class T1 {


    @GetMapping("/taaa")
    @RequiresPermissions("aa:bb:vc")
    @Log()
    public String t1(){
     return "没有异常";
    }

}
