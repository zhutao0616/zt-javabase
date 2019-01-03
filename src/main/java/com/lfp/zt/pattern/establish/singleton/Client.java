package com.lfp.zt.pattern.establish.singleton;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2019-01-02
 * Copyright: Copyright (c) 2019
 * Company: qudian
 *
 * @author ZhuTao
 * @version 2.0
 */
public class Client {

    public static void main(String[] args){
        System.out.println(LazySingleton.getInstance());
        System.out.println(InnerSingleton.getInstance());
        System.out.println(EnumSingleton.instance);
    }

}
