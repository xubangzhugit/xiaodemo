package com.example.student;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyProtoBufClient {

    public static void main(String[] args) throws Exception{
        EventLoopGroup wocker = new NioEventLoopGroup();
        try{
            Bootstrap bs = new Bootstrap();
            bs.group(wocker).channel(NioSocketChannel.class).handler(new NettyProtoBufClientInit());
            ChannelFuture sync = bs.connect("localhost",8899).sync();
            Channel channel = sync.channel();
           /* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            for(;;){
                channel.writeAndFlush(br.readLine());
            }*/
        }finally{
            wocker.shutdownGracefully();
        }
    }
}
