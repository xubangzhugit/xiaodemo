package com.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;

public class ChannelInit extends iMyChanneInit{
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline channelPepiline = ch.pipeline();

    }
}
