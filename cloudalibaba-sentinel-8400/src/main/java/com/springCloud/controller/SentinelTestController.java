package com.springCloud.controller;

import cn.hutool.core.net.NetUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.sun.deploy.security.BlockedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SentinelTestController {
    @Value("${sever.port}")
    private String port;

    @GetMapping("/sentinel/getport")
    @ResponseBody
    public String getport() {
        return port;
    }

    @GetMapping("/test_Deal/{id}/{name}")
    @SentinelResource(value = "test_Deal",blockHandler = "/dualFunction" )
    public String test_Deal(@PathVariable("id") String id,@PathVariable("name") String name){
     return "";
    }
    public String dualFunction(String id, String name, BlockedException E){
        NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        return "出错的兜底方法提示";
    }
}
