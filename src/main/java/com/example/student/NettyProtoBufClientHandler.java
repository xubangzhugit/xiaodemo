package com.example.student;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyProtoBufClientHandler extends SimpleChannelInboundHandler<DataInfo.Student> {
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
        System.out.println("channelRegistered");
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
        System.out.println("userEventTriggered");
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        super.handlerAdded(ctx);
        System.out.println("handlerAdded");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        DataInfo.Student.Builder builder = DataInfo.Student.newBuilder().setName("aaa").setAge(19).setAddress("beijin");
        DataInfo.Student build = builder.build();
       /* Channel channel = ctx.channel();
        BufferedReader br;
        do {
            br = new BufferedReader(new InputStreamReader(System.in));
        }while (br.readLine()=="1");*/
        ctx.writeAndFlush(build);

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Student msg) throws Exception {
        System.out.println("channelRead0");

    }
}
