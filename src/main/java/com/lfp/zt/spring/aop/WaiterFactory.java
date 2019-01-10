package com.lfp.zt.spring.aop;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2019-01-09
 * Copyright: Copyright (c) 2019
 * Company:
 *
 * @author ZhuTao
 * @version 2.0
 */
public class WaiterFactory {

    public static Waiter getProxy(){
        Waiter target = new WaiterImpl();
        GreetAdvice beforeAdvice = new GreetAdvice();
        ServeAdvice interceptorAdvice = new ServeAdvice();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(beforeAdvice);
        proxyFactory.addAdvice(interceptorAdvice);

        return (Waiter) proxyFactory.getProxy();
    }

}
