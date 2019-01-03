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
 * Company: LFP
 *
 * @author ZhuTao
 * @version 2.0
 */
public class ServerHandler implements Runnable {
    /** 线程计数器 */
    private CountDownLatch latch;
    /** socket服务通道 */
    private AsynchronousServerSocketChannel serverChannel;

    ServerHandler(int port) {
        try {
            //开启服务端通道
            serverChannel = AsynchronousServerSocketChannel.open();
            //绑定端口
            serverChannel.bind(new InetSocketAddress(port));
            System.out.println("服务器已启动，端口号：" + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        //初始化计数器，挂起线程，直到出现异常退出
        latch = new CountDownLatch(1);
        //接收客户端的连接，建立连接后执行读操作 ReadHandler
        serverChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            @Override
            public void completed(AsynchronousSocketChannel socketChannel, Void attachment) {
                //继续接受其他客户端的请求
                Server.clientCount++;
                System.out.println("连接的客户端数：" + Server.clientCount);
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
