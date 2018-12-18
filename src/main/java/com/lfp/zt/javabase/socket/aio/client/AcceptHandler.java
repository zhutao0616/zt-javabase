package com.lfp.zt.javabase.socket.aio.client;

import java.io.IOException;
import java.nio.channels.CompletionHandler;

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
public class AcceptHandler implements CompletionHandler<Void, ClientHandler> {

    //连接服务器成功
    //意味着TCP三次握手完成
    @Override
    public void completed(Void result, ClientHandler clientHandler) {
        System.out.println("客户端成功连接到服务器...");
    }
    //连接服务器失败
    @Override
    public void failed(Throwable exc, ClientHandler clientHandler) {
        System.err.println("连接服务器失败...");
        exc.printStackTrace();
        try {
            clientHandler.clientChannel.close();
            clientHandler.latch.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
