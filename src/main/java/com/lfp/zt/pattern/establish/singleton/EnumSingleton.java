package com.lfp.zt.pattern.establish.singleton;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2019-01-02
 * Copyright: Copyright (c) 2019
 * Company: LFP
 *
 * @author ZhuTao
 * @version 2.0
 */
public enum EnumSingleton {
    instance;

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" 运行......";
    }

}
