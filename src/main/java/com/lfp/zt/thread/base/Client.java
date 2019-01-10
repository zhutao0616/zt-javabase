package com.lfp.zt.thread.base;

import java.util.concurrent.*;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2019-01-10
 * Copyright: Copyright (c) 2019
 * Company:
 *
 * @author ZhuTao
 * @version 2.0
 */
public class Client {

    private void thread(){
        new MyThread().start();
    }

    private void runnable(){
        Runnable runnable = new MyRunnable();
        new Thread(runnable, "Runnable-Thread").start();
    }

    private void callable(){
        Callable<String> callable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        new Thread(futureTask, "Callable-Thread").start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void submit(){
        ExecutorService executor = Executors.newCachedThreadPool();
        Callable<String> callable = new MyCallable();
        Future<String> future = executor.submit(callable);
        executor.shutdown();
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Client client = new Client();
        //继承Thread类的线程创建
        client.thread();
        //实现runnable的线程创建
        client.runnable();
        //实现callable的线程创建
        client.callable();
        //利用线程池获取线程返回值
        client.submit();
    }

}
