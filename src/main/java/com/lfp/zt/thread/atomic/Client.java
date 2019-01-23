package com.lfp.zt.thread.atomic;

import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2019-01-21
 * Copyright: Copyright (c) 2019
 * Company:
 *
 * @author ZhuTao
 * @version 2.0
 */
public class Client {


    private static void testAtomicReference(){
        Integer old_ = 500;
        Integer new_ = 600;
        AtomicReference<Integer> obj = new AtomicReference<>(old_);

        Thread t1 = new Thread(() -> {
            System.out.println(obj.compareAndSet(old_, new_));
            System.out.println(obj.compareAndSet(new_, old_));
        });

        try {
            t1.start();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(obj.compareAndSet(old_, new_));
    }

    private static void testAtomicMarkableReference(){
        Integer old_ = 500;
        Integer new_ = 600;
        AtomicMarkableReference<Integer> obj = new AtomicMarkableReference<>(old_, true);
        final boolean mark = obj.isMarked();

        Thread t1 = new Thread(() -> {
            System.out.println(obj.compareAndSet(old_, new_, obj.isMarked(), !obj.isMarked()));
            System.out.println(obj.compareAndSet(new_, old_, obj.isMarked(), !obj.isMarked()));
        });

        try {
            t1.start();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(obj.compareAndSet(old_, new_, mark, !mark));
    }

    private static void testAtomicStampedReference(){
        Integer old_ = 500;
        Integer new_ = 600;
        AtomicStampedReference<Integer> obj = new AtomicStampedReference<>(old_, 0);
        final int stamp = obj.getStamp();

        Thread t1 = new Thread(() -> {
            System.out.println(obj.compareAndSet(old_, new_, obj.getStamp(), obj.getStamp()+1));
            System.out.println(obj.compareAndSet(new_, old_, obj.getStamp(), obj.getStamp()+1));
        });

        try {
            t1.start();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(obj.compareAndSet(old_, new_, stamp, stamp+1));
    }

    public static void main(String[] args){
        testAtomicReference();
        System.out.println("========================");
        testAtomicMarkableReference();
        System.out.println("========================");
        testAtomicStampedReference();

    }
}
