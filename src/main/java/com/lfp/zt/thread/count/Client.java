package com.lfp.zt.thread.count;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

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

    private void countDownLatch(){
        CountDownLatch latch = new CountDownLatch(2);

        new Thread(() -> {
            try {
                System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                Thread.sleep(3000);
                System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                Thread.sleep(4000);
                System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void cyclicBarrier(){
        CyclicBarrier barrier = new CyclicBarrier(2, () -> System.out.println("拦截后，子线程"+Thread.currentThread().getName()+"再做......"));

        new Thread(() -> {
            try {
                System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                Thread.sleep(3000);
                System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                Thread.sleep(2000);
                System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println("主线程不阻塞，直接结束！");
    }

    private void semaphore(){
        Semaphore semaphore = new Semaphore(2);

        for (int i=1;i<=5;i++){
            new Thread(()->{
                try {
                    semaphore.acquire(1);
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(2000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                    semaphore.release(1);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void main(String[] args){
        Client client = new Client();
        client.countDownLatch();
        System.out.println("====================");
        client.cyclicBarrier();
        System.out.println("====================");
        client.semaphore();
    }

}
