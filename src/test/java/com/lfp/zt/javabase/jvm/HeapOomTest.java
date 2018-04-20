package com.lfp.zt.javabase.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: zt-javabase
 * Title: 堆溢出测试
 * Description: 测试堆溢出问题
 * Date: 2018-4-17
 * Copyright: Copyright (c) 2018
 * Company: LFP
 *
 * @author ZhuTao
 * @version 1.0
 */
public class HeapOomTest {

    private static class OOMObject{
        private long[] longs = new long[1000];
    }

    public static void main(String[] args){
        List<OOMObject> list = new ArrayList<>();
        while (true) list.add(new OOMObject());
    }

}
