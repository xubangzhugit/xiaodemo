package com.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;


public class FristNetty {


    public static void main(String[] args) {
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        ServerBootstrap bs = new ServerBootstrap();
        bs.group(boss,worker).channel(NioServerSocketChannel.class);
        bs.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline channelPipeline = ch.pipeline();
                channelPipeline.addLast(new HttpServerCodec());
                channelPipeline.addLast(new SimpleChannelInboundHandler<HttpObject>() {


                    @Override
                    public void channelActive(ChannelHandlerContext ctx) throws Exception {
                        System.out.println("channelactive");
                        super.channelActive(ctx);
                    }

                    @Override
                    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
                        System.out.println(msg.getClass());
                        if(msg instanceof  HttpRequest){
                            System.out.println("执行messageRechived");
                            System.out.println("获取远程地址"+ctx.channel().remoteAddress());
                            ByteBuf hello = Unpooled.copiedBuffer("hello", CharsetUtil.UTF_8);
                            FullHttpResponse fullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.OK,hello);
                            fullHttpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
                            fullHttpResponse.headers().setInt(HttpHeaderNames.CONTENT_LENGTH,hello.readableBytes());
                            ctx.writeAndFlush(fullHttpResponse);
                        }
                    }

                    @Override
                    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                        super.exceptionCaught(ctx, cause);
                        ctx.close();//出现异常，关闭channel

                    }
                });
               // channelPipeline.addLast(new ChannelInit());
            }
        });
        try {
            ChannelFuture sync = bs.bind(8899).sync();
            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
           boss.shutdownGracefully();
           worker.shutdownGracefully();
        }

    }
}
