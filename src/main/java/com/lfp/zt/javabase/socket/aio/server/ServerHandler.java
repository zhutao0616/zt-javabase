package com.lfp.zt.javabase.socket.aio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2018-12-16
 * Copyright: Copyright (c) 2018
 * Company: qudian
 *
 * @author ZhuTao
 * @version 2.0
 */
public class ServerHandler implements Runnable {
    public CountDownLatch latch;
    public AsynchronousServerSocketChannel channel;
    public ServerHandler(int port) {
        try {
            //创建服务端通道
            channel = AsynchronousServerSocketChannel.open();
            //绑定端口
            channel.bind(new InetSocketAddress(port));
            System.out.println("服务器已启动，端口号：" + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        //CountDownLatch初始化
        //它的作用：在完成一组正在执行的操作之前，允许当前的现场一直阻塞
        //此处，让现场在此阻塞，防止服务端执行完成后退出
        //也可以使用while(true)+sleep
        //生成环境就不需要担心这个问题，以为服务端是不会退出的
        latch = new CountDownLatch(1);
        //用于接收客户端的连接
        //channel.accept(null, new AcceptHandler(channel, latch));
        channel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            @Override
            public void completed(AsynchronousSocketChannel socketChannel, Void attachment) {
                //继续接受其他客户端的请求
                Server.clientCount++;
                System.out.println("连接的客户端数：" + Server.clientCount);
                //channel.accept(null, this);
                //创建新的Buffer
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                //异步读  第三个参数为接收消息回调的业务Handler
                socketChannel.read(buffer, buffer, new ReadHandler(socketChannel));
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                exc.printStackTrace();
                latch.countDown();
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
