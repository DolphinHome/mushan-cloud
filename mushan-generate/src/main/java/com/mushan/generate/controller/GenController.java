package com.mushan.generate.controller;

import com.mushan.generate.service.GenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenController {
    @Autowired
    private GenService genService;


    @GetMapping("list")
    public Object list(){
        return genService.list();
    }

}
