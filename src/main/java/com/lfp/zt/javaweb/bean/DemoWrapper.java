package com.lfp.zt.javaweb.bean;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2018/11/8
 * Copyright: Copyright (c) 2018
 * Company: LFP
 *
 * @author ZhuTao
 * @version 2.0
 */
public class DemoWrapper {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        DemoWrapper demo = new DemoWrapper();
        BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(demo);

        System.out.println(demo.getName());
        bw.setPropertyValue("name", "zhutao");
        System.out.println(demo.getName());
        bw.setPropertyValue("name", "gujuanjuan");
        System.out.println(demo.getName());

    }
}
