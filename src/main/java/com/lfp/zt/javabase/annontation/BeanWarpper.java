package com.lfp.zt.javabase.annontation;

import java.lang.reflect.InvocationTargetException;
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
public class BeanWarpper<T> {
    private T object;

    public BeanWarpper(T object) {
        this.object = object;
    }

    public Object doMethod(String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = object.getClass();
        Method method = clazz.getMethod(methodName);
        MyMethod myMethod = method.getAnnotation(MyMethod.class);
        Object ret;
        if (myMethod!=null) {
            long begin = System.currentTimeMillis();
            ret = method.invoke(object);
            long end = System.currentTimeMillis();
            System.out.println(myMethod.value() + (end - begin));
        }else{
            ret = method.invoke(object);
        }
        return ret;
    }
}
