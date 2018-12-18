package com.lfp.zt.javabase.socket.aio.server;

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
public class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Void> {
    private AsynchronousServerSocketChannel serverChannel;
    private CountDownLatch latch;

    public AcceptHandler(AsynchronousServerSocketChannel serverChannel, CountDownLatch latch) {
        this.serverChannel = serverChannel;
        this.latch = latch;
    }

    @Override
    public void completed(AsynchronousSocketChannel channel, Void attachment) {
        //继续接受其他客户端的请求
        Server.clientCount++;
        System.out.println("连接的客户端数：" + Server.clientCount);
        serverChannel.accept(null, this);
        //创建新的Buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //异步读  第三个参数为接收消息回调的业务Handler
        channel.read(buffer, buffer, new ReadHandler(channel));
    }
    @Override
    public void failed(Throwable exc, Void attachment) {
        exc.printStackTrace();
        latch.countDown();
    }
}
