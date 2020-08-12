package com.springCloud.service;


import com.springCloud.pojo.CommonResult;
import com.springCloud.pojo.House;
import feign.Feign;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceimpl implements FeignService {
    @Override
    public CommonResult<House> create(House house) {
        return new CommonResult<>();
    }

    @Override
    public CommonResult<House> gethouse(Integer id) {
        return null;
    }
}
