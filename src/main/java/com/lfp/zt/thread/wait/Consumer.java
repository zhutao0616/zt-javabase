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
public class Consumer implements Runnable {

    private final Vector<Integer> QUEUE;
    private final int SIZE;

    public Consumer(Vector<Integer> QUEUE, int SIZE) {
        this.QUEUE = QUEUE;
        this.SIZE = SIZE;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumer: " + consume());
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private Integer consume() throws InterruptedException {
        while (QUEUE.isEmpty()) {
            synchronized (QUEUE) {
                System.out.println("Queue is empty " + Thread.currentThread().getName()
                        + " is waiting , size: " + QUEUE.size());
                QUEUE.wait();
            }
        }

        //otherwise consume element and notify waiting producer
        synchronized (QUEUE) {
            QUEUE.notifyAll();
            return QUEUE.remove(0);
        }
    }
}
