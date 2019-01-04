package com.lfp.zt.thread;

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

    public static List<String> runSync(List<Task> syncTasks) {
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

    public static void main(String [] args){
        List<Task> syncTasks = new ArrayList<>();
        for (int i=0;i<20;i++){
            syncTasks.add(new TaskImpl());
        }
        System.out.println("======================");

        //父线程设置值
        ThreadTrace.set("123");
        List<String> results = runSync(syncTasks);
        results.forEach(System.out::println);

        System.out.println("======================");

        //父线程设置值
        ThreadTrace.set("456");
        results = runSync(syncTasks);
        results.forEach(System.out::println);


    }

}
