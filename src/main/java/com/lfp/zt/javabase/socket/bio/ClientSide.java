package com.lfp.zt.javabase.socket.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2018-12-10
 * Copyright: Copyright (c) 2018
 * Company: qudian
 *
 * @author ZhuTao
 * @version 2.0
 */
public class ClientSide {
    private static String host = "127.0.0.1";
    private static int port = 8888;

    public static void send(String message){
        try(Socket socket = new Socket(host,port);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true)){
            System.out.println("发送内容为：" + message);
            //向服务端发生一个message
            writer.println(message);
            //获取服务端对返回结果
            System.out.println("接收内容为：" + reader.readLine());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Random random = new Random(System.currentTimeMillis());
        for (int i=0;i<10;i++){
            int finalI = i;
            new Thread(() -> {
                while(true){
                    //随机产生算术表达式
                    send("这是第【"+ finalI +"】个信息");
                    try {
                        Thread.currentThread().sleep(random.nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
