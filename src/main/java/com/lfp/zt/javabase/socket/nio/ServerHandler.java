package com.lfp.zt.javabase.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2018-12-11
 * Copyright: Copyright (c) 2018
 * Company: qudian
 *
 * @author ZhuTao
 * @version 2.0
 */
public class ServerHandler implements Runnable {

    /** 服务端运行状态 */
    private volatile boolean running;
    /** 多路选择器 */
    private Selector selector;
    /** 服务端网络通道 */
    private ServerSocketChannel channel;

    public ServerHandler(int port) throws IOException {
        //开启选择器和通道
        selector = Selector.open();
        channel = ServerSocketChannel.open();
        //通道设置为非阻塞式
        channel.configureBlocking(false);
        //绑定端口
        channel.bind(new InetSocketAddress(port));
        //监听客户端链接请求
        channel.register(selector, SelectionKey.OP_ACCEPT);
        //标记服务已开启
        running = true;
        System.out.println("服务器已启动，端口号：" + port);
    }

    @Override
    public void run() {
        while (running){
            try {
                selector.select(1000);
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                SelectionKey key;
                while (it.hasNext()){
                    key = it.next();
                    it.remove();
                    try{
                        handleInput(key);
                    }catch (Exception e){
                        if (key != null){
                            key.cancel();
                            if (key.channel()!=null){
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (selector != null){
            try{
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()){
            System.out.println(key.readyOps());
            //处理新接入的请求消息
            if (key.isAcceptable()){
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                sc.register(selector, SelectionKey.OP_READ);
            }
            //读消息
            if (key.isReadable()){
                SocketChannel sc = (SocketChannel) key.channel();
                //创建ByteBuffer，并开辟一个1M的缓冲区
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                //读取请求码流，返回读取到的字节数
                int readBytes = sc.read(buffer);
                //读取到字节，对字节进行编解码
                if(readBytes>0){
                    //将缓冲区当前的limit设置为position=0，用于后续对缓冲区的读取操作
                    buffer.flip();
                    //根据缓冲区可读字节数创建字节数组
                    byte[] bytes = new byte[buffer.remaining()];
                    //将缓冲区可读字节数组复制到新建的数组中
                    buffer.get(bytes);
                    String line = new String(bytes,"UTF-8");
                    System.out.println("服务器收到消息：" + line);
                    //处理数据
                    String result = "服务端处理[" +line+ "]并返回";
                    //发送应答消息
                    doWrite(sc,result);
                }else if(readBytes<0){
                    key.cancel();
                    sc.close();
                }
            }
        }
    }

    private void doWrite(SocketChannel sc, String result) throws IOException {
        //将消息编码为字节数组
        byte[] bytes = result.getBytes();
        //根据数组容量创建ByteBuffer
        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
        //将字节数组复制到缓冲区
        writeBuffer.put(bytes);
        //flip操作
        writeBuffer.flip();
        //发送缓冲区的字节数组
        sc.write(writeBuffer);
    }
}
