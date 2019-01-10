package com.lfp.zt.spring.aop;

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
public class WaitressImpl implements Waiter {

    @Override
    public void greetTo(String name) {
        System.out.println("Waitress greet to "+name);
    }

    @Override
    public void serveTo(String name) {
        System.out.println("Waitress serve to "+name);
    }

}
