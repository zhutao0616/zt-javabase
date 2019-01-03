package com.lfp.zt.javabase.socket.aio.server;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;

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
public class ReadHandler implements CompletionHandler<Integer, ByteBuffer> {
    /** socket通道 */
    private AsynchronousSocketChannel channel;

    ReadHandler(AsynchronousSocketChannel channel) {
        this.channel = channel;
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        // flip操作，以便可以从头开始读缓存
        // limit = position;position = 0;mark = -1
        attachment.flip();
        // 根据待读取的内容大小建立相应的数组
        byte[] message = new byte[attachment.remaining()];
        // 读取内容
        attachment.get(message);
        String str = new String(message, StandardCharsets.UTF_8);
        System.out.println("服务器收到消息：" + str);

        //向客户端发送消息
        String ret = "服务端处理[" + str + "]并返回";
        byte[] bytes = ret.getBytes();
        //创建相应的写缓存区
        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
        writeBuffer.put(bytes);
        writeBuffer.flip();
        //异步写数据 参数与前面的read一样
        channel.write(writeBuffer, writeBuffer, new WriteHandler(channel));

    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        exc.printStackTrace();
        System.err.println("数据读取失败...");
        try {
            this.channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
