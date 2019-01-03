package com.lfp.zt.javabase.dynamicProxy;

import java.lang.reflect.Proxy;

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
public class GreetFactory {

    public static GreetV2 createAdapter(GreetV1 greetV1){
        GreetAdapter adapter = new GreetAdapter(greetV1);
        return (GreetV2) Proxy.newProxyInstance(GreetV1.class.getClassLoader(), new Class[]{GreetV2.class}, adapter);
    }
}
