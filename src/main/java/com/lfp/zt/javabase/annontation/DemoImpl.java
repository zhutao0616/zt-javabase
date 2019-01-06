package com.lfp.zt.javabase.annontation;

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
public class DemoImpl implements Demo {
    private String name;

    public DemoImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        try {
            Thread.sleep((long) (Math.random()*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name;
    }

    @Override
    public void setName(String name) {
        try {
            Thread.sleep((long) (Math.random()*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.name = name;
    }
}
