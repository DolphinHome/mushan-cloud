package com.mushan.system.service;


import com.mushan.common.security.annotation.RequiresPermissions;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;


@FeignClient(value = "mushan-gateway")
public interface TestService {


    @GetMapping("/test/t2")
    public void t2();

}
