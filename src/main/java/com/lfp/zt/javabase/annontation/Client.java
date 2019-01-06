package com.lfp.zt.javabase.annontation;

import java.lang.reflect.InvocationTargetException;

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

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        BeanWarpper<Demo> demo = new BeanWarpper<>(new Demo());
        System.out.println(demo.doMethod("getName"));
    }
}
