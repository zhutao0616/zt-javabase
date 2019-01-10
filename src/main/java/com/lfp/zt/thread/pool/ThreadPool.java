package com.lfp.zt.thread.pool;

import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Project: zt-javabase
 * Title: 线程池
 * Description: 对基本的线程池进行包装，保证主子线程之间可以传递参数
 * @see java.util.concurrent.Executor[I]
 * @see java.util.concurrent.ExecutorService[I]
 * @see java.util.concurrent.AbstractExecutorService[A]
 *      @see java.util.concurrent.ForkJoinPool[C]
 * @see java.util.concurrent.ThreadPoolExecutor[C]
 *      @see java.util.concurrent.ScheduledThreadPoolExecutor[C]
 *  |- org.apache.tomcat.util.threads.ThreadPoolExecutor[C]
 *  |- org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor[C-has]
 *
 * @see java.util.concurrent.Executors
 *  |- newSingleThreadExecutor  创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
 *  |- newFixedThreadPool       创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
 *  |- newCachedThreadPool      创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
 *  |- newScheduledThreadPool   创建一个定长线程池，支持定时及周期性任务执行
 *
 *  |- newWorkStealingPool      创建一个可以工作窃取的线程池，ForkJoinPool
 *
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
