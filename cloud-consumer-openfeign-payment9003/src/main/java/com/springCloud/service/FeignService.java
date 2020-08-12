package com.springCloud.service;

import com.springCloud.pojo.CommonResult;
import com.springCloud.pojo.House;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT",fallback = FeignServiceimpl.class)

public interface FeignService {
     @PostMapping(value = "/house/create")
     @ResponseBody
     CommonResult<House> create(@RequestBody House house);

     @ResponseBody
     @GetMapping("/house/gethouse")
     CommonResult<House> gethouse(Integer id);
}
