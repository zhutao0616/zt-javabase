package com.lfp.zt.javabase.annontation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2019-01-06
 * Copyright: Copyright (c) 2019
 * Company:
 *
 * @author ZhuTao
 * @version 2.0
 */
public class DynamicProxy implements InvocationHandler {

    private Object realObject;

    public DynamicProxy(Object realObject) {
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Proxy Class : " + proxy.getClass().toString());
        System.out.println("Proxy Method : " + method.toString());
        TimeAble timeAble = method.getAnnotation(TimeAble.class);
        if ( timeAble != null){
            long begin = System.currentTimeMillis();
            Object ret = method.invoke(realObject, args);
            long end = System.currentTimeMillis();
            System.out.println("Method Cost Time: " + (end-begin));
            return ret;
        }
        return method.invoke(realObject, args);
    }
}
