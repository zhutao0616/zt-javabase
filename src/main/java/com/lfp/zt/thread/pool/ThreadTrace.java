package com.lfp.zt.thread.pool;

import com.alibaba.ttl.TransmittableThreadLocal;

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
public class ThreadTrace {
    public final static String DEFAULT_TRACE = "666666";

    private final static TransmittableThreadLocal<String> local = new TransmittableThreadLocal<>();

    public static String get() {
        return local.get();
    }

    public static void set(String traceId) {
        local.set(traceId);
    }

    public static void restore() {
        local.set(DEFAULT_TRACE);
    }

    public static void clear() {
        local.remove();
    }
}
