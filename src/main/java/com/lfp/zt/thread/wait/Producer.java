package com.lfp.zt.thread.wait;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

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
public class Producer implements Runnable {

    private final Vector<Integer> QUEUE;
    private final int SIZE;

    public Producer(Vector<Integer> QUEUE, int SIZE) {
        this.QUEUE = QUEUE;
        this.SIZE = SIZE;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Producer: " + i);
            try {
                produce(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void produce(int i) throws InterruptedException {
        while (QUEUE.size()==SIZE){
            synchronized (QUEUE){
                System.out.println("Queue is full " + Thread.currentThread().getName()
                        + " is waiting , size: " + QUEUE.size());
                QUEUE.wait();
            }
        }
        synchronized (QUEUE){
            QUEUE.add(i);
            QUEUE.notifyAll();
        }
    }
}
