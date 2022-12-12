package com.mushan.mq.controller;

import com.mushan.common.log.annotation.Log;
import com.mushan.common.security.annotation.RequiresPermissions;
import com.mushan.utlis.ResponseUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class T1 {


    @GetMapping("/taaa")
    @RequiresPermissions("aa:bb:vc")
    @Log()
    public Object t1(){
     return ResponseUtils.ok("成功");
    }

}
