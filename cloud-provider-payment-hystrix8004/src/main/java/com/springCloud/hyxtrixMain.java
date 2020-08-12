package com.springCloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
/*@EnableHystrix*/
@EnableEurekaClient
@EnableCircuitBreaker//开启服务降级
public class hyxtrixMain {
    public static void main(String[] args){
         SpringApplication.run(hyxtrixMain.class,args);
    }

    /**
     * dashboard 监控需要此bean
     * @return
     */
     @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet() {
        ServletRegistrationBean regist = new ServletRegistrationBean();
        regist.setServlet(new HystrixMetricsStreamServlet());
        regist.setName("hystrixMetricsStreamServlet");
        regist.setLoadOnStartup(1);
        regist.addUrlMappings("/hystrix.stream");
        return regist;
    }
}
