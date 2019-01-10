package com.lfp.zt.thread.wait;

import java.util.Vector;

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

    public static void main(String[] args){
        Vector<Integer> queue = new Vector<>();
        int max = 10;
        Producer producer = new Producer(queue, max);
        Consumer consumer = new Consumer(queue, max);
        new Thread(producer, "Producer-Thread").start();
        new Thread(consumer, "Consumer-Thread").start();
    }
}
