package com.lfp.zt.javabase.dynamicProxy;

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
public class RealSubject implements Subject {

    @Override
    public void hello() {
        System.out.println("Hello World!");
    }

    @Override
    public Object handle(Object param) {
        return param;
    }

}
