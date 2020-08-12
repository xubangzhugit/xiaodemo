package com.springCloud.controller;

import com.springCloud.pojo.CommonResult;
import com.springCloud.pojo.House;
import com.springCloud.service.HouseService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Slf4j
public class HouseController {
   final static  Logger logger =LoggerFactory.getLogger(HouseController.class);

    @Resource
    private HouseService houseService;
    @Value("${server.port}")
    private String port;
    @Autowired
    private DiscoveryClient discoveryClient;//DiscoveryClient服务发现


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
    /**
     * 显示服务发现
     * @return
     */
    @RequestMapping(value = "/house/discovery", method = RequestMethod.GET)
    @ResponseBody
    public Object discovery() {
        List<String> list = discoveryClient.getServices();//获取eureka中的服务
        log.info("******" + list);
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        for (ServiceInstance serviceInstance : serviceInstances) {
            log.info(serviceInstance.getServiceId() + "\t" +
                    serviceInstance.getHost() + "\t" +
                    serviceInstance.getPort() + "\t" +
                    serviceInstance.getUri());
        }
        return this.discoveryClient;
    }
    @GetMapping(value = "/house/getport")
    @ResponseBody
    public String getport(){
        return port;
    }
}
