package com.lfp.zt.javabase.socket.nio;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2018-12-13
 * Copyright: Copyright (c) 2018
 * Company: LFP
 *
 * @author ZhuTao
 * @version 2.0
 */
public class ClientSide {

    /** 服务端地址 */
    private static final String host = "127.0.0.1";
    /** 服务端端口 */
    private static final int port = 8888;

    public static void send(String message) throws Exception {
        ClientHandle client = new ClientHandle(host, port);
        Thread.sleep(2000);
        new Thread(client,"Client").start();
        Thread.sleep(2000);
        client.sendMsg(message);
    }
    public static void main(String[] args) throws Exception {
        send("test");
    }
}
