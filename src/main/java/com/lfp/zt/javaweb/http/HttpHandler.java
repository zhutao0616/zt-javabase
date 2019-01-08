package com.lfp.zt.javaweb.http;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2019-01-08
 * Copyright: Copyright (c) 2019
 * Company:
 *
 * @author ZhuTao
 * @version 2.0
 */
public class HttpHandler implements Runnable {
    private SelectionKey selectionKey;

    public HttpHandler(SelectionKey selectionKey) {
        this.selectionKey = selectionKey;
    }

    @Override
    public void run() {
        try{
            if (selectionKey.isAcceptable()){
                handleAccept();
            }
            if (selectionKey.isReadable()){
                handleRead();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void handleAccept() throws IOException {
        SocketChannel socketChannel = ((ServerSocketChannel)selectionKey.channel()).accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selectionKey.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(1024));
    }

    private void handleRead() throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
        byteBuffer.clear();
        if (socketChannel.read(byteBuffer)==-1){
            socketChannel.close();
        }else{
            byteBuffer.flip();
            String str = new String(byteBuffer.array(), StandardCharsets.UTF_8);
            String[] requestMessage = str.split("\r\n");
            for (String s:requestMessage){
                System.out.println(s);
                //空行后续内容不再读取
                if (s.isEmpty()) break;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("HTTP/1.1 200 OK\r\n");
            sb.append("Content-Type:text/html;charset=UTF-8\r\n");
            sb.append("\r\n");
            sb.append("<html><head><title>标题</title></head><body>");
            sb.append("接收到的请求报文是：<br/>");
            Arrays.stream(requestMessage).forEach(msg->sb.append(msg).append("<br/>"));
            sb.append("</body></html>");

            byteBuffer = ByteBuffer.wrap(sb.toString().getBytes(StandardCharsets.UTF_8));
            socketChannel.write(byteBuffer);
            socketChannel.close();
        }
    }
}
