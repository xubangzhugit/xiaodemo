package com.springCloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced //调用loadbalanced 赋予resttemplate负载均衡(默认轮询)
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
