package com.lfp.zt.thread.base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

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

    public static void main(String[] args){
        Client client = new Client();
        client.thread();
        client.runnable();
        client.callable();
    }

}
