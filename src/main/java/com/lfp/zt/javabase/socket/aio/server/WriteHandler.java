package com.lfp.zt.javabase.socket.aio.server;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2018-12-19
 * Copyright: Copyright (c) 2018
 * Company: LFP
 *
 * @author ZhuTao
 * @version 2.0
 */
public class WriteHandler implements CompletionHandler<Integer, ByteBuffer> {
    /** socket通道 */
    private AsynchronousSocketChannel channel;

    WriteHandler(AsynchronousSocketChannel channel) {
        this.channel = channel;
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        //创建新的Buffer
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        //异步读  第三个参数为接收消息回调的业务Handler
        channel.read(readBuffer, readBuffer, new ReadHandler(channel));
    }
    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        exc.printStackTrace();
        System.err.println("数据回复失败...");
        try {
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
