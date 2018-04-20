package com.lfp.zt.javabase.binary;

import org.junit.Test;

/**
 * Project: zt-javabase
 * Title: int测试
 * Description: 测试int及其装箱类型的特性
 * Date: 2018-4-13
 * Copyright: Copyright (c) 2018
 * Company: LFP
 *
 * @author ZhuTao
 * @version 1.0
 */
public class IntegerTest {

    @Test
    public void testMem(){
        int i1 = 59;
        Integer i2 = 59;
        Integer i3 = Integer.valueOf(59);

        Integer i4 = new Integer(59);

        System.out.println(i1==i2);
        System.out.println(i1==i3);
        System.out.println(i1==i4);

        System.out.println(i2==i3);
        System.out.println(i2==i4);

        System.out.println(i3==i4);


        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i5==i6);

    }

    @Test
    public void testEqual(){
        Integer i1 = new Integer(59);
        Integer i2 = new Integer(59);

        System.out.println(i1==i2);


        String s1 = new String("123");
        String s2 = new String("123");

        System.out.println(s1==s2);
    }

}
