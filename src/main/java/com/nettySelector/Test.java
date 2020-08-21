package com.nettySelector;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test {
    public static void main(String[] args) throws Exception {
        int[] ports = new int[5];
        ports[0] = 5000;
        ports[1] = 5001;
        ports[2] = 5002;
        ports[3] = 5003;
        ports[4] = 5004;
        Selector selector = Selector.open(); //创建一个seletor 对象
        for (int i = 0; i < ports.length; ++i) {
            ServerSocketChannel serverSocketchannel = ServerSocketChannel.open();//创建一个ServerSocketchannel 对象
            serverSocketchannel.configureBlocking(false);   //设置非阻塞模式
            ServerSocket serverSocket = serverSocketchannel.socket(); //获得Serversocket
            InetSocketAddress address = new InetSocketAddress(ports[i]);
            serverSocket.bind(address); //ServerSocket绑定端口
            serverSocketchannel.register(selector, SelectionKey.OP_ACCEPT); //注册ACCEPT 事件（当前只能注册ACCEPT事件）
            System.out.println("监听端口: " + ports[i]);
        }
        while (true) {
            int numbers = selector.select(); //返回selectkey的数量
            System.out.println("numbers:" + numbers);
            Set<SelectionKey> selectionkeys = selector.selectedKeys();//返回selectkey的集合
            Iterator<SelectionKey> iter = selectionkeys.iterator(); //迭代
            while (iter.hasNext()) {
                SelectionKey selectionkey = iter.next();
                if (selectionkey.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionkey.channel();
                    SocketChannel socketchannel = serverSocketChannel.accept();
                    socketchannel.configureBlocking(false);
                    socketchannel.register(selector, SelectionKey.OP_READ);
                    iter.remove(); //移除selectkey
                    System.out.println("获得客户端连接:" + socketchannel);
                } else if (selectionkey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionkey.channel();
                    int bytesRead = 0;
                    while (true) {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                        byteBuffer.clear();
                        int read = socketChannel.read(byteBuffer);
                        if (read <= 0) {
                            break;
                        }
                        byteBuffer.flip();
                        socketChannel.write(byteBuffer);
                        bytesRead += read;
                    }
                    System.out.println("读取:" + bytesRead + "来自于:" + socketChannel);
                    iter.remove();
                }
            }
        }
    }
}
