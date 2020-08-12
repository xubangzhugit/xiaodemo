package com.springCloud.controller;

import com.springCloud.service.MessageProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class Messagecontroller {
    public int a = 0;
    @Resource
    private MessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String getmessage() {
        return messageProvider.send();
    }
}
