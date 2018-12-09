package com.lfp.zt.javabase.dynamicProxy;


import java.lang.reflect.Proxy;

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
public class ProxyFactory {

    public static <T> T createProxy(Class<T> intf, final T realObject){
        DynamicProxy proxy = new DynamicProxy(realObject);
        return (T) Proxy.newProxyInstance(realObject.getClass().getClassLoader(), new Class[]{intf}, proxy);
    }

}
