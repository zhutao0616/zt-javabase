package com.lfp.zt.javabase.classLoader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2019-01-05
 * Copyright: Copyright (c) 2019
 * Company:
 *
 * @author ZhuTao
 * @version 2.0
 */
public class Client {

    public static void system() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());


        //loader.loadClass("com.lfp.zt.javabase.classLoader.Demo");
        //Class.forName("com.lfp.zt.javabase.classLoader.Demo");
        Class clazz = Class.forName("com.lfp.zt.javabase.classLoader.Demo", false, loader);
        clazz.newInstance();
    }

    public static void custom() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        MyClassLoader loader = new MyClassLoader("/Users/qudian/zhutao/zt-javabase/src/main/java ");
        Class clazz = loader.loadClass("com.lfp.zt.javabase.classLoader.Demo");
        clazz.newInstance();
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        custom();

    }

    public static void reflect() throws ClassNotFoundException {
        //反射获取类对象
        Class clazz = Class.forName("com.lfp.zt.javabase.classLoader.Demo");
        //方法
        Method[] methods = clazz.getMethods();
        //静态方法
        Method[] dms = clazz.getDeclaredMethods();
        //属性
        Field[] fields = clazz.getFields();
        //静态属性
        Field[] dfs = clazz.getDeclaredFields();
        //构造方法
        Constructor[] constructors = clazz.getConstructors();

    }


}
