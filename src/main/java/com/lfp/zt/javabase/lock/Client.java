package com.lfp.zt.javabase.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2019-01-13
 * Copyright: Copyright (c) 2019
 * Company:
 *
 * @author ZhuTao
 * @version 2.0
 */
public class Client {

    private static void testCAS(){
        CountSync cs = new CountSync(10);
        System.out.println(cs.compareAndSetSyncState(10,9));
        cs.setSyncState(10);
        cs.setSyncState(9);
        System.out.println(cs.compareAndSetSyncState(9,10));

    }

    private static void testLockSupport(){
        AtomicInteger value = new AtomicInteger();

        Thread t1 = new Thread(() -> {
            try {
                for (int i=0;;i++,value.addAndGet(1)){
                    System.out.println(Thread.currentThread()+"第["+i+"]次执行");
                    Thread.sleep(200L);
                    if (value.get()==20){
                        LockSupport.park();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (;;){
                    if (value.get()==20){
                        System.out.println(Thread.currentThread()+"执行");
                        LockSupport.unpark(t1);
                    }
                    Thread.sleep(200L);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }

    private static void testOnlyLock(){
        OnlyLock lock = new OnlyLock();

        for (int i=0;i<10;i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread()+"开始");
                    Thread.sleep(2000L);
                    System.out.println(Thread.currentThread()+"结束");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }).start();
        }

    }

    private static void testSharedLock(){
        SharedLock lock = new SharedLock();

        for (int i=0;i<10;i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread()+"开始");
                    Thread.sleep(4000L);
                    System.out.println(Thread.currentThread()+"结束");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }).start();
        }

    }

    public static void main(String[] args){
        //testCAS();
        testLockSupport();
        //testOnlyLock();
        //testSharedLock();
    }

}
