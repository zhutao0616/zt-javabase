package com.lfp.zt.javabase.lock;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2019-01-23
 * Copyright: Copyright (c) 2019
 * Company:
 *
 * @author ZhuTao
 * @version 2.0
 */
public class AdderDemo {
    private static final int TASK_COUNT = 100;
    private static final int TARGET_COUNT = 1000000;

    private long syncCount = 0L;
    private AtomicLong atomicCount = new AtomicLong(0L);
    private LongAdder adderCount = new LongAdder();

    private synchronized long inc(){
        return ++syncCount;
    }

    public long getSyncCount() {
        return syncCount;
    }

    public AtomicLong getAtomicCount() {
        return atomicCount;
    }

    public LongAdder getAdderCount() {
        return adderCount;
    }

    public void testSync() throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(TASK_COUNT);
        CyclicBarrier cb = new CyclicBarrier(TASK_COUNT);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TASK_COUNT; i++) {
            new Thread(() -> {
                try {
                    cb.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                for (int i1 = 0; i1 <TARGET_COUNT; i1++){
                    inc();
                }
                cdl.countDown();
            }).start();
        }
        cdl.await();
        long endTime = System.currentTimeMillis();
        System.out.println("SyncThread spend:" + (endTime - startTime) + "ms, result:"+getSyncCount());
    }

    public void testAtomic() throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(TASK_COUNT);
        CyclicBarrier cb = new CyclicBarrier(TASK_COUNT);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TASK_COUNT; i++) {
            new Thread(() -> {
                try {
                    cb.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                for (int i1 = 0; i1 <TARGET_COUNT; i1++){
                    getAtomicCount().incrementAndGet();
                }
                cdl.countDown();
            }).start();
        }
        cdl.await();
        long endTime = System.currentTimeMillis();
        System.out.println("SyncThread spend:" + (endTime - startTime) + "ms, result:"+getAtomicCount().longValue());
    }

    public void testAdder() throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(TASK_COUNT);
        CyclicBarrier cb = new CyclicBarrier(TASK_COUNT);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TASK_COUNT; i++) {
            new Thread(() -> {
                try {
                    cb.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                for (int i1 = 0; i1 <TARGET_COUNT; i1++){
                    getAdderCount().increment();
                }
                cdl.countDown();
            }).start();
        }
        cdl.await();
        long endTime = System.currentTimeMillis();
        System.out.println("SyncThread spend:" + (endTime - startTime) + "ms, result:"+getAdderCount().longValue());
    }


    public static void main(String[] args) throws InterruptedException {
        AdderDemo demo = new AdderDemo();
        demo.testSync();
        demo.testAtomic();
        demo.testAdder();
    }
}
