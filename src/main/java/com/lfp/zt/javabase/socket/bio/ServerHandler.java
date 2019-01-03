package com.lfp.zt.javabase.socket.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

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
public class ServerHandler implements Runnable {
    private Socket socket;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true)){
            String line;
            String result;
            //通过BufferedReader读取一行
            //如果已经读到输入流尾部，返回null,退出循环
            //如果得到非空值，就尝试计算结果并返回
            while((line = reader.readLine())!=null){
                System.out.println("服务器收到消息：" + line);
                result = "服务端处理[" +line+ "]并返回";
                writer.println(result);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
