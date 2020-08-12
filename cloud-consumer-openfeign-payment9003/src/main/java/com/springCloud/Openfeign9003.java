package com.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Openfeign9003 {

    public static void main(String[] args){
         SpringApplication.run(Openfeign9003.class,args);
    }
}
