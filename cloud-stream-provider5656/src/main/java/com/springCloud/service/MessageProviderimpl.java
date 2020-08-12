package com.springCloud.service;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

@EnableBinding(Source.class)
@Slf4j
public class MessageProviderimpl implements MessageProvider {
    @Resource
    private MessageChannel channel;

    @Override
    public String send() {
        channel.send(MessageBuilder.withPayload(IdUtil.simpleUUID()).build());
        int i = 0 ;
        log.info("send:"+(++i));
        return null;
    }
}
