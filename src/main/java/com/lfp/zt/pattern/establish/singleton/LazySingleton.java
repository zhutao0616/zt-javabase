package com.lfp.zt.pattern.establish.singleton;

/**
 * Project: zt-javabase
 * Title: 懒汉式单例
 * Description: 利用双重校验锁方式实现。
 * Date: 2019-01-02
 * Copyright: Copyright (c) 2019
 * Company: LFP
 *
 * @author ZhuTao
 * @version 2.0
 */
public class LazySingleton {

    private volatile static LazySingleton instance;

    private LazySingleton() {
        System.out.println(this.getClass().getSimpleName()+" 初始化......");
    }

    public static LazySingleton getInstance(){
        if (instance==null){                        // 首次检测，减少后续加锁操作调用次数
            synchronized (LazySingleton.class){     // 加锁，保证顺序执行
                if (instance==null){                // 再次检测，因为首次检测可能会进来多个线程，在加锁后顺序执行，
                                                    // 在次此检测可以保证只有第一个线程执行，后续的就无需执行。
                    instance = new LazySingleton(); // 该步骤包括：1、分配内存空间，2、初始化对象，3、对象指向内存，
                                                    // 因为new对象是多个指令，可能出现重排序，利用volatile关键字防止重排序
                }
            }
        }
        return instance;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" 运行......";
    }
}
