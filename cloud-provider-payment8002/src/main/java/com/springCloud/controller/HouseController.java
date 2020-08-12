package com.springCloud.controller;

import com.springCloud.pojo.CommonResult;
import com.springCloud.pojo.House;
import com.springCloud.service.HouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class HouseController {
   final static  Logger logger =LoggerFactory.getLogger(HouseController.class);

    @Resource
    private HouseService houseService;
    @Value("${server.port}")
    private String port;
   @PostMapping(value = "/house/create")
   @ResponseBody
   public CommonResult<House> create(@RequestBody House house){
       int i = houseService.create(house);
       logger.info(port+"插入数据："+i);
       if(i<=0){
           return new CommonResult<>(250,"fail");
       }
       return new CommonResult<>(200,"success",house);
   }
    @GetMapping(value = "/house/gethouse")
    @ResponseBody
    public CommonResult<House> getHouse(Integer uid){
        House houseById = houseService.getHouseById(uid);
        logger.info(port+"读取数据："+houseById);
        if(houseById ==null){
            return new CommonResult<>(250,"fail");
        }
        return new CommonResult<>(200,"success",houseById);
    }
    @GetMapping(value = "/house/getport")
    @ResponseBody
    public String getport(){
       return port;
    }
}
