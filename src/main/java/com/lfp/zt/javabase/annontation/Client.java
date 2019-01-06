package com.lfp.zt.javabase.annontation;

import com.lfp.zt.javabase.dynamicProxy.ProxyFactory;

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
public class Client {

    public static void main(String[] args) {

        Demo demo = ProxyFactory.createProxy(Demo.class, new DemoImpl("zt"));
        System.out.println(demo.getName());
        demo.setName("GJJ");
        System.out.println(demo.getName());
    }
}
