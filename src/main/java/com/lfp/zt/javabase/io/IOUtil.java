package com.lfp.zt.javabase.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2018-12-09
 * Copyright: Copyright (c) 2018
 * Company: qudian
 *
 * @author ZhuTao
 * @version 2.0
 */
public class IOUtil {


    private void viewBuffer(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(32);
        byteBuffer.putInt(1);
        System.out.println(byteBuffer.getInt());

        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        intBuffer.put(2);
        System.out.println(byteBuffer.getInt());

    }

    private void fileChannel() throws IOException {
        FileChannel channel = FileChannel.open(Paths.get("out.txt"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        ByteBuffer buffer = ByteBuffer.allocate(64);
        buffer.putInt(123456).flip();

        channel.write(buffer);
    }


    private void loadWebPage(String url, String path) throws IOException {
        try(FileChannel desChannel = FileChannel.open(Paths.get(path), StandardOpenOption.CREATE, StandardOpenOption.WRITE)){
            InputStream inputStream = new URL(url).openStream();
            ReadableByteChannel srcChannel = Channels.newChannel(inputStream);

            desChannel.transferFrom(srcChannel,0,Integer.MAX_VALUE);
        }
    }
    private void copyWebPage(String src, String des) throws IOException {
        try(FileChannel srcChannel = FileChannel.open(Paths.get(src), StandardOpenOption.READ)){
            OutputStream outputStream = new FileOutputStream(des);
            WritableByteChannel desChannel = Channels.newChannel(outputStream);

            srcChannel.transferTo(0, Integer.MAX_VALUE, desChannel);
        }
    }

    private void loadWebBySocket(String host, String path) throws IOException {
        try(FileChannel desChannel = FileChannel.open(Paths.get(path), StandardOpenOption.CREATE, StandardOpenOption.WRITE)){

            SocketChannel srcChannel = SocketChannel.open(new InetSocketAddress(host, 443));
            String request = "GET / HTTP/1.1\r\n\rHost: "+host+"\r\n";
            ByteBuffer header = ByteBuffer.wrap(request.getBytes("UTF-8"));
            srcChannel.write(header);

            desChannel.transferFrom(srcChannel,0,Integer.MAX_VALUE);
        }
    }

    public static void main(String[] args) throws IOException {
        IOUtil util = new IOUtil();
        //util.viewBuffer();
        //util.fileChannel();
        //util.loadWebPage("https://www.baidu.com/", "baidu.html");
        //util.copyWebPage("baidu.html", "my.html");
        util.loadWebBySocket("www.baidu.com", "baidu.html");
    }

}
