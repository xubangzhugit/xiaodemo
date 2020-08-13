package com.springCloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController

public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String REQUESTURL;

    @GetMapping("/nacos/consumer/getport")
    public String getport() {
        return restTemplate.getForObject(REQUESTURL + "/nacos/geport", String.class);
    }
}
