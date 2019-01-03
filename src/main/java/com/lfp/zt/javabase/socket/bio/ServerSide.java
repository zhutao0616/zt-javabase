package com.lfp.zt.javabase.socket.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2018-12-10
 * Copyright: Copyright (c) 2018
 * Company: LFP
 *
 * @author ZhuTao
 * @version 2.0
 */
public class ServerSide {
    private static int port = 8888;
    //线程池，懒汉式单例
    private static ExecutorService executorPool = Executors.newFixedThreadPool(10);
    //服务端，饿汉式单例
    private static ServerSocket server;

    private static void run() throws IOException {
        if(server != null) return;
        try {
            server = new ServerSocket(port);
            System.out.println("服务器已启动，端口号：" + port);
            while(true){
                Socket socket = server.accept();
                //当有新的客户端接入时，会执行下面的代码
                //然后创建一个新的线程处理这条Socket链路
                executorPool.execute(new ServerHandler(socket));
            }
        } finally {
            //一些必要的清理工作
            if(server != null){
                System.out.println("服务器已关闭。");
                server.close();
                server = null;
            }
        }
    }

    public static void main(String[] args){
        try {
            run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
