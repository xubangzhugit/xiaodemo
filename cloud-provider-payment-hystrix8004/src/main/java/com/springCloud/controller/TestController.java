package com.springCloud.controller;

import com.springCloud.service.TestOK;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class TestController {
        @Resource
        private TestOK testOK;

        @GetMapping("/hyxtrix/testok")
        @ResponseBody
        public String testok(){
           return testOK.ok();
        }
    @GetMapping("/hyxtrix/timeout")
    @ResponseBody
    public String timeout(){
        return testOK.TimeOut();
    }
    @GetMapping("/hyxtrix/CircuitBreaker/{id}")
    @ResponseBody
    public String CircuitBreaker(@PathVariable Integer id){
        return testOK.CircuitBreaker(id);
    }
}
