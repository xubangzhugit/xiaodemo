package com.springCloud.controller;

import com.springCloud.pojo.CommonResult;
import com.springCloud.pojo.House;
import com.springCloud.service.FeignService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

@Controller
public class OpenfeignController {
    @Resource
    private FeignService feignService;
    @PostMapping("/openfeign/house/gethouse")
    public CommonResult<House> Openfeign(@RequestBody House house){
        return feignService.create(house);
    }
}
