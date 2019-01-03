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
public class GreetAdapter implements InvocationHandler {

    private GreetV1 greetV1;

    public GreetAdapter(GreetV1 greetV1) {
        this.greetV1 = greetV1;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if ("getId".equals(methodName)){
            Method oldMethod = GreetV1.class.getMethod(methodName, Integer.class);
            //参数适配
            Integer oldParam = Integer.valueOf(args[0].toString());
            //调用老接口
            Object oldResult = oldMethod.invoke(greetV1, oldParam);
            //结果适配
            String newResult = oldResult.toString();
            //返回新接口格式
            return newResult;
        }
        return method.invoke(greetV1, args);
    }
}
