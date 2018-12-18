package com.lfp.zt.javabase.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
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
public class ClientHandle implements Runnable {

    /** 客户端运行状态 */
    private volatile boolean running;
    /** 多路选择器 */
    private Selector selector;
    /** 客户端网络通道 */
    private SocketChannel channel;

    public ClientHandle(String host, int port) throws IOException {
        //开启选择器和通道
        selector = Selector.open();
        channel = SocketChannel.open();
        //通道设置为非阻塞式
        channel.configureBlocking(false);
        //标记服务已开启
        running = true;
        // 连接到服务端
        if(channel.connect(new InetSocketAddress(host,port))){
            System.out.println("客户端已启动，连接到["+host+":"+port+"]");
        }else{
            channel.register(selector, SelectionKey.OP_CONNECT);
        }
    }


    @Override
    public void run() {
        while (running){
            try {
                selector.select(1000);
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                SelectionKey key;
                while(it.hasNext()){
                    key = it.next();
                    it.remove();
                    try{
                        handleInput(key);
                    }catch(Exception e){
                        if(key != null){
                            key.cancel();
                            if(key.channel() != null){
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
        if(key.isValid()){
            System.out.println(key.readyOps());
            if(key.isConnectable()){
                SocketChannel sc = (SocketChannel) key.channel();
                if(sc.finishConnect()){
                    System.out.println("连接完成");
                } else {
                    System.exit(1);
                }
            }
            if(key.isReadable()){
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
                    String result = new String(bytes,"UTF-8");
                    System.out.println("客户端收到消息：" + result);
                }else if(readBytes<0){
                    //链路已经关闭，释放资源
                    key.cancel();
                    sc.close();
                }
            }
        }
    }

    public void sendMsg(String msg) throws Exception{
        channel.register(selector, SelectionKey.OP_READ);
        doWrite(channel, msg);
    }

    private void doWrite(SocketChannel channel,String request) throws IOException{
        //将消息编码为字节数组
        byte[] bytes = request.getBytes();
        //根据数组容量创建ByteBuffer
        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
        //将字节数组复制到缓冲区
        writeBuffer.put(bytes);
        //flip操作
        writeBuffer.flip();
        //发送缓冲区的字节数组
        channel.write(writeBuffer);
    }

}
