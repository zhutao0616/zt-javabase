package com.lfp.zt.javabase.socket.nio;

import java.io.IOException;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2018-12-13
 * Copyright: Copyright (c) 2018
 * Company: qudian
 *
 * @author ZhuTao
 * @version 2.0
 */
public class ServerSide {
    /** 服务端端口 */
    private static final int port = 8888;

    private static void run() throws IOException {
        ServerHandler server = new ServerHandler(port);
        new Thread(server,"Server").start();
    }

    public static void main(String[] args) {
        try {
            run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
