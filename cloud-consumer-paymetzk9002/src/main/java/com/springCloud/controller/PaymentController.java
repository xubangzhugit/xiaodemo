package com.springCloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Controller
public class PaymentController {
      public static  final  String URL ="http://cloud-provider-payment";
      @Resource
      private RestTemplate restTemplate;
       @GetMapping("/paymentzk")
       @ResponseBody
      public String getPaymentzk(){
              return restTemplate.getForObject(URL+"/payment/zk",String.class);
       }
}
