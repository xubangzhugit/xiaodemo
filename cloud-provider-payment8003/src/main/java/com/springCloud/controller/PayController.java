package com.springCloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@Slf4j
public class PayController {
    @Value("${server.port}")
    private String port;
    @GetMapping(value = "/payment/zk")
    public String maymentZk(){
        return "spring cloud payment"+port+ Instant.now();
    }
}
