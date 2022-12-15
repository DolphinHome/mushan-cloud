package com.mushan.login.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface UserFeign {
}
