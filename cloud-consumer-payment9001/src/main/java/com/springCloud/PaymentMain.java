package com.springCloud;

import com.myrule.Rule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="CLOUD-PROVIDER-PAYMENT",configuration = Rule.class)
public class PaymentMain {
    public static void main(String[] args){
        SpringApplication.run(PaymentMain.class,args);
    }
}
