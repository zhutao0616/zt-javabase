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
public class Client {

    private void customProxy(){
        Subject realSubject = new RealSubject();

        SubjectProxy proxy = new SubjectProxy(realSubject);

        Subject subject = (Subject) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), new Class[]{Subject.class}, proxy);

        subject.hello();
        System.out.println("------------------------");
        Object ret = subject.handle("ZT LOVE GJJ!");
        System.out.println("------------------------");
        System.out.println(ret);
    }

    private void abstractProxy(){
        Subject realSubject = new RealSubject();

        Subject subject = ProxyFactory.createProxy(Subject.class, realSubject);

        subject.hello();
        System.out.println("------------------------");
        Object ret = subject.handle("GJJ LOVE ZT!");
        System.out.println("------------------------");
        System.out.println(ret);
    }


    private void adaptProxy(){
        GreetV1 real = number -> number;
        GreetV2 proxy = GreetFactory.createAdapter(real);
        String ret = proxy.getId("123");
        System.out.println(ret);
    }

    public static void main(String[] args){
        Client client = new Client();
        client.customProxy();
        System.out.println("************************");
        client.abstractProxy();
        System.out.println("************************");
        client.adaptProxy();
    }
}
