package com.springCloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestConntroller {
    @Value("${server.port}")
    private String port;
    @GetMapping("/nacos/geport")
    public String getport(){
        return "---------------"+port;
    }
}
