package com.lfp.zt.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
public class Client {

    public void normal(String name){
        Waiter waiter = new WaiterImpl();
        waiter.greetTo(name);
        waiter.serveTo(name);
    }

    public void proxy(String name){
        Waiter waiter = WaiterFactory.getProxy();
        waiter.greetTo(name);
        waiter.serveTo(name);
    }

    public void spring(String name){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("waiter.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo(name);
        waiter.serveTo(name);
    }

    public static void main(String[] args){
        Client client = new Client();
        System.out.println("==========normal==========");
        client.normal("zt");
        System.out.println("==========proxy==========");
        client.proxy("zt");
        System.out.println("==========spring==========");
        client.spring("zt");
    }

}
