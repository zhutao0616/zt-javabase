package com.lfp.zt.javabase.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2018/11/7
 * Copyright: Copyright (c) 2018
 * Company: qudian
 *
 * @author ZhuTao
 * @version 2.0
 */
public class DemoServer {

    public static void main(String[] args) {
        try {
            int port = 8888;
            ServerSocket server = new ServerSocket(port);
            Socket socket = server.accept();

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = br.readLine();
            System.out.println("服务端接收到信息："+line);

            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println("[response]"+line);
            pw.flush();
            pw.close();
            br.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
