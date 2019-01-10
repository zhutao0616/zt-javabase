package com.lfp.zt.thread.pool;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2019-01-03
 * Copyright: Copyright (c) 2019
 * Company: LFP
 *
 * @author ZhuTao
 * @version 2.0
 */
public interface Task<T> {

    T call();

}
