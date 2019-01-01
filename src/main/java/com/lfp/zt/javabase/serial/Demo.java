package com.lfp.zt.javabase.serial;

import java.io.Serializable;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2018-12-31
 * Copyright: Copyright (c) 2018
 * Company: qudian
 *
 * @author ZhuTao
 * @version 2.0
 */
public class Demo implements Serializable {

    private String name;

    private int version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
