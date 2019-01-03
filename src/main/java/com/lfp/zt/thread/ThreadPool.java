package com.lfp.zt.thread;

import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2019-01-03
 * Copyright: Copyright (c) 2019
 * Company: LFP
 *
 * @author ZhuTao
 * @version 2.0
 */
public class ThreadPool {

    public static final ExecutorService pool = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(10));

}
