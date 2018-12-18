package com.lfp.zt.javabase.socket.aio.client;

import java.io.IOException;
import java.nio.ByteBuffer;
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
public class AcceptHandler implements CompletionHandler<Void, Void> {
    private AsynchronousSocketChannel clientChannel;
    private CountDownLatch latch;

    public AcceptHandler(AsynchronousSocketChannel clientChannel, CountDownLatch latch) {
        this.clientChannel = clientChannel;
        this.latch = latch;
    }

    //连接服务器成功
    //意味着TCP三次握手完成
    @Override
    public void completed(Void result, Void attachment) {
        System.out.println("客户端成功连接到服务器...");
    }
    //连接服务器失败
    @Override
    public void failed(Throwable exc, Void attachment) {
        System.err.println("连接服务器失败...");
        exc.printStackTrace();
        try {
            clientChannel.close();
            latch.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
