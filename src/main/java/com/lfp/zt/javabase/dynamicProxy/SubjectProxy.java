package com.lfp.zt.javabase.dynamicProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2018-12-09
 * Copyright: Copyright (c) 2018
 * Company: LFP
 *
 * @author ZhuTao
 * @version 2.0
 */
public class SubjectProxy implements InvocationHandler {

    private Object subject;

    public SubjectProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy Class : " + proxy.getClass().toString());
        System.out.println("Proxy Method : " + method.toString());

        System.out.println("[Before AOP]");
        Object ret = method.invoke(subject, args);
        System.out.println("[After AOP]");

        return ret;
    }
}
