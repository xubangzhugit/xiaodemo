package com.springCloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class Readconfig {
    @Value("${config.info}")
    private String info;
    @GetMapping("/config/getconfig")
    public String getConfigInfo(){
        return info;
    }
}
