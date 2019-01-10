package com.lfp.zt.javabase.jvm;

import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2019-01-03
 * Copyright: Copyright (c) 2019
 * Company:
 *
 * @author ZhuTao
 * @version 2.0
 */
public class Client {

    public static void main(String[] args){
        System.out.println(Runtime.getRuntime().availableProcessors());

        System.out.println(ForkJoinPool.getCommonPoolParallelism());
        Executors.newWorkStealingPool();



        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
    }

}
