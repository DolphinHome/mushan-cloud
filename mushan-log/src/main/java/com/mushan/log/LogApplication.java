package com.mushan.log;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.mushan.log.dao")
public class LogApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(LogApplication.class, args);
    }


}
