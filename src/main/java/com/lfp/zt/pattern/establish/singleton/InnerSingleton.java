package com.lfp.zt.pattern.establish.singleton;

/**
 * Project: zt-javabase
 * Title: 内部类单例
 * Description: 利用内部类加装时的单一性保证，由JVM来保证线程安全
 * Date: 2019-01-02
 * Copyright: Copyright (c) 2019
 * Company: LFP
 *
 * @author ZhuTao
 * @version 2.0
 */
public class InnerSingleton {

    private static class SingletonHolder {
        private static final InnerSingleton instance = new InnerSingleton();
    }

    private InnerSingleton(){
        System.out.println(this.getClass().getSimpleName()+" 初始化......");
    }

    public static InnerSingleton getInstance(){
        return SingletonHolder.instance;                //SingletonHolder 被使用时，会加载，从而示例化instance
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" 运行......";
    }

}
