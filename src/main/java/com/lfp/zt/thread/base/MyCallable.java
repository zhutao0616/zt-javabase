package com.lfp.zt.thread.base;

import java.util.concurrent.Callable;

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
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " running...");
        return "MyCallableFeature";
    }
}
