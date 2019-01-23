package com.lfp.zt.javabase.lock;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

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
public class MySync {

    class Node{
        Thread thread;
    }

    private volatile Thread currentThread;

    private AtomicInteger state = new AtomicInteger(0);
    private Queue<Node> queue = new LinkedBlockingQueue<>();


    public boolean tryAcquire(int i) {
        System.out.println(Thread.currentThread().getName()+"tryAcquire......");
        if (state.compareAndSet(0,1)){
            currentThread = Thread.currentThread();
            return true;
        }
        return false;
    }

    public void acquire(int i) {
        while (!tryAcquire(i)){
            //获取不到锁，就把线程park
            Node node = new Node();
            node.thread = Thread.currentThread();
            queue.offer(node);
            System.out.println(node.thread.getName()+"入队并阻塞，队列长度"+queue.size());
            LockSupport.park();
            //将本线程阻塞，等待被唤醒后继续执行
        }
    }

    public void release(int i) {
        if (currentThread == Thread.currentThread()){
            state.set(0);
            currentThread = null;
        }
        if (!queue.isEmpty()){
            Node next = queue.poll();
            System.out.println(next.thread.getName()+"出队并唤醒，队列长度"+queue.size());
            LockSupport.unpark(next.thread);
            //唤醒线程继续执行while，继续cas操作，失败就继续阻塞
        }
    }
}
