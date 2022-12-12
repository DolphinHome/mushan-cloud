package com.mushan.system.service;


import com.mushan.common.security.annotation.RequiresPermissions;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Component
@FeignClient(value = "mushan-mq")
public interface TestService {


    @GetMapping("/mq/taaa")
    public Object t2();

}
