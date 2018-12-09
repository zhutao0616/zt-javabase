package com.lfp.zt.javabase.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2018-12-09
 * Copyright: Copyright (c) 2018
 * Company: qudian
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

        System.out.println("[Can do something before method.]");
        Object ret = method.invoke(realObject, args);
        System.out.println("[Can do something after method.]");

        return ret;
    }
}
