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
public class Demo {
    private String name;

    @MyMethod("耗时")
    public String getName() {
        return name;
    }

    @MyMethod("耗时")
    public void setName(String name) {
        this.name = name;
    }
}
