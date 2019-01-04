package com.lfp.zt.thread;

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
public class TaskImpl implements Task<String> {

    @Override
    public String call() {
        System.out.println(Thread.currentThread().getName()+"正在运行...");
        //获取从父线程copy过来的内容
        String result = ThreadTrace.get();
        //ThreadTrace.clear();
        return result;
    }

}
