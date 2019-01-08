package com.lfp.zt.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2019-01-05
 * Copyright: Copyright (c) 2019
 * Company:
 *
 * @author ZhuTao
 * @version 2.0
 */
public class MyThreadPool {
    private int threadCount;
    private WorkThread[] handlers;
    private final List<Runnable> taskQueue = new ArrayList<>();

    public MyThreadPool(int threadCount) {
        this.threadCount = threadCount;
        this.handlers = new WorkThread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            handlers[i] = new WorkThread();
            handlers[i].start();
        }
    }

    public void shutdown() {
        synchronized (taskQueue) {
            while (!taskQueue.isEmpty())
                taskQueue.remove(0); //清空任务队列
        }
        for (int i = 0; i < threadCount; i++) {
            //handlers[i] = new WorkThread();
            handlers[i].interrupt(); //结束线程
        }
    }

    public void execute(Runnable newTask) { //增加新任务
        synchronized (taskQueue) {
            taskQueue.add(newTask);
            taskQueue.notifyAll();
        }
    }

    private class WorkThread extends Thread {
        public void run() {
            Runnable task = null;
            for (; ; ) {
                synchronized (taskQueue) {//获取一个新任务
                    if (taskQueue.isEmpty()) {
                        try {
                            taskQueue.wait();
                            task = taskQueue.remove(0);
                        } catch (InterruptedException e) {
                            break;
                        }
                    }
                }
                assert task != null;
                task.run();
            }
        }
    }

}
