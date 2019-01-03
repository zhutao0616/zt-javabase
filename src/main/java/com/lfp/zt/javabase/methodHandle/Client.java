package com.lfp.zt.javabase.methodHandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

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
public class Client {


    private void invokeExact() throws Throwable {
        MethodType type = MethodType.methodType(String.class, String.class);

        MethodHandle mh = MethodHandles.lookup().findVirtual(Demo.class, "test", type);

        String ret = (String)mh.invokeExact(new Demo(), "Hello World!");

        System.out.println(ret);
    }

    public static void main(String[] args){
        Client client = new Client();
        try {
            client.invokeExact();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
