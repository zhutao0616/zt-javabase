package com.lfp.zt.thread.wait;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2019-01-20
 * Copyright: Copyright (c) 2019
 * Company:
 *
 * @author ZhuTao
 * @version 2.0
 */
public class NotifyAllTest {
    private static final Object obj = new Object();
    public static void main(String[] args) {

        ThreadA t1 = new ThreadA("t1");
        ThreadA t2 = new ThreadA("t2");
        ThreadA t3 = new ThreadA("t3");
        t1.start();
        t2.start();
        t3.start();

        try {
            System.out.println(Thread.currentThread().getName()+" sleep(5000)");
            // 等待一段时间，确保子线程开始运行，并争夺了obj的锁，并且都进入到了wait
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //子线程都进入wait后，synchronized的obj锁释放后，此处才能争取到锁
        synchronized(obj) {
            System.out.println(Thread.currentThread().getName()+" notifyAll()");
            // 主线程唤醒其他等待在obj上到线程，但是需要等到这里释放锁后才能执行。
            obj.notifyAll();
        }
    }

    static class ThreadA extends Thread{

        public ThreadA(String name){
            super(name);
        }

        public void run() {
            synchronized (obj) {
                try {
                    System.out.println(Thread.currentThread().getName() + " beginning");
                    // 占有obj的锁并工作一段时间
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " waiting");
                    // 进入等待状态，并释放obj的锁，等待被唤醒
                    obj.wait();
                    System.out.println(Thread.currentThread().getName() + " continue");
                    // 唤醒后重新获得obj的锁并继续工作一段时间
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " finished");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
