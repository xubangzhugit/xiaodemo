package com.springCloud.service;

import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
@DefaultProperties(defaultFallback = "timeoutfall")//批量回调
public class TestOK {

     public String ok(){

         return Thread.currentThread().getName()+"ok";
     }
    @HystrixCommand(fallbackMethod = "timeoutfall",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
     public String TimeOut()  {
         try {
             TimeUnit.SECONDS.sleep(13000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         return Thread.currentThread().getName()+"timeout";
     }

    /**
     * 服务降级方法
     * @return
     */
    public String timeoutfall()  {
        return Thread.currentThread().getName()+"timeout12";
    }

    /**
     * 服务熔断
     * ：在时间窗口期10000毫秒的时间内，请求10次，失败率达到60%后跳闸
     */
    @HystrixCommand (fallbackMethod = "paymentcircuitBreaker_fallback" ,commandProperties ={
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold" , value ="10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage" , value ="60")//失败率达到多少后跳闸
    })
    public String CircuitBreaker(@PathVariable Integer id){
        if(id>10){
          throw new RuntimeException("错误");
        }
        String s = IdUtil.simpleUUID();
        return s;
    }
    public String paymentcircuitBreaker_fallback(@PathVariable Integer id){
        return "hahahah";
    }
}
