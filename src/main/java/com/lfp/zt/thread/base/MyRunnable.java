package com.lfp.zt.thread.base;

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
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " running...");
    }
}
