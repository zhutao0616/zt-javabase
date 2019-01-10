package com.lfp.zt.thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

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
public class Client {

    public static List<String> supplyAsync(List<Task> syncTasks) {
        List<String> result = new ArrayList<>();
        long start = System.currentTimeMillis();
        CompletableFuture[] cfs = syncTasks.stream().map(object-> CompletableFuture
                .supplyAsync((Supplier<Object>) object::call, ThreadPool.pool)
                .whenComplete((v, e) -> {
                    if ( e!=null){
                        result.add("ERROR");
                    }else {
                        result.add((String) v);
                    }
                }))
                .toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(cfs).join();
        System.out.println("同步任务全部完成!耗时="+(System.currentTimeMillis()-start));
        return result;
    }

    public static void runAsync(List<Task> syncTasks) {
        long start = System.currentTimeMillis();
        syncTasks.forEach(object-> CompletableFuture.runAsync(object::call, ThreadPool.pool));
        System.out.println("异步任务全部完成!耗时="+(System.currentTimeMillis()-start));
    }

    public static void main(String [] args){
        List<Task> syncTasks = new ArrayList<>();
        for (int i=0;i<20;i++){
            syncTasks.add(new TaskImpl());
        }
        System.out.println("======================");

        //同步等待子线程运行结束并获取结果
        ThreadTrace.set("123");//父线程设置值
        List<String> results = supplyAsync(syncTasks);
        results.forEach(System.out::println);

        System.out.println("======================");

        //异步执行，执行结果进入队列
        ThreadTrace.set("456");//父线程设置值
        runAsync(syncTasks);
    }

}
