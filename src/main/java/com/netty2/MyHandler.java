package com.netty2;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

public class MyHandler extends ChannelInboundHandlerAdapter {
    /**
     * 用户事件触发，
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
       if(evt instanceof IdleStateEvent){
           IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
           String eventtype = null;
           switch (idleStateEvent.state()){
               case READER_IDLE:
                   System.out.println("读空闲");
                   break;
               case WRITER_IDLE:
                   System.out.println("写空闲");
                   break;
               case ALL_IDLE:
                   System.out.println("读写空闲");
                   break;
           }
           System.out.println("");
       }

    }
}
