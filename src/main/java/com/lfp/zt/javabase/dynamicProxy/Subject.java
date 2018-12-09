package com.lfp.zt.javabase.dynamicProxy;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2018-12-08
 * Copyright: Copyright (c) 2018
 * Company: qudian
 *
 * @author ZhuTao
 * @version 2.0
 */
public interface Subject {

    void hello();

    Object handle(Object param);

}
