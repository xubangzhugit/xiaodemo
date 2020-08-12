package com.springCloud.controller;

import com.springCloud.LB.Mylb;
import com.springCloud.pojo.CommonResult;
import com.springCloud.pojo.House;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@Slf4j
@RestController
public class HouseController {
  public static final String URL="http://CLOUD-PROVIDER-PAYMENT";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private Mylb mylb;
    @PostMapping("/consumer/house/create")
    public CommonResult<House> create(@RequestBody House  house){
        log.info("consumer/create");
      return  restTemplate.postForObject(URL+"/house/create",house,CommonResult.class);
    }
    @GetMapping("/consumer/house/gethouse")
    public CommonResult<House> get(Integer uid){
        log.info("consumer/gethouse");
        return  restTemplate.getForObject(URL+"/house/gethouse?uid="+uid,CommonResult.class);
    }
    @GetMapping("/consumer/getPaymentLb")
    public String getPaymentLb(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        ServiceInstance serviceinstance = mylb.serviceinstance(instances);
        URI  uri = serviceinstance.getUri();
        return restTemplate.getForObject(uri+"/house/getport",String.class);
    }
}
