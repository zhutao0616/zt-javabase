package com.lfp.zt.javabase.binary;

import org.junit.Test;

/**
 * Project: zt-javabase
 * Title: 数值测试
 * Description: 测试各种进制的数据的表示形式，测试 bit byte 等
 * Date: 2018-4-10
 * Copyright: Copyright (c) 2018
 * Company: LFP
 *
 * @author ZhuTao
 * @version 1.0
 */
public class NumberTest {

    //进制测试
    @Test
    public void testHex(){
        //二进制
        int one = 0b0000_0000_1111_1111;
        //八进制
        int two = 0377;
        //十进制
        int three = 255;
        //十六进制
        int four = 0xff;

        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.println(four);
    }

    //加减测试
    @Test
    public void testPlusMinus(){
        System.out.println(Integer.toBinaryString(255));
        System.out.println(Integer.toBinaryString(-255));

        int zh = 0b0_0000000_00000000_00000000_11111111;
        int fu = 0b1_1111111_11111111_11111111_00000001;

        System.out.println(zh);
        System.out.println(fu);

        System.out.println(12-3);
        System.out.println(12 + (~3+1));

    }

    //补码测试
    @Test
    public void testComplement(){
        int zh_y = 0b0_0000000_00000000_00000000_11111111;
        int zh_f = 0b0_0000000_00000000_00000000_11111111;
        int zh_b = 0b0_0000000_00000000_00000000_11111111;

        int fu_y = 0b1_0000000_00000000_00000000_11111111;
        int fu_f = 0b1_1111111_11111111_11111111_00000000;
        int fu_b = 0b1_1111111_11111111_11111111_00000001;

        System.out.println(zh_y);
        System.out.println(zh_f);
        System.out.println(zh_b);

        System.out.println(fu_y);
        System.out.println(fu_f);
        System.out.println(fu_b);
    }

    //位测试
    @Test
    public void bitTest(){
        // 1byte = 8bit
        byte b  = 0b0_1111111;
        byte b_ = (byte) 0b1_0000000;
        // 2byte = 16bit
        short s  = 0b0_1111111_11111111;
        short s_ = (short) 0b1_0000000_00000000;
        // 4byte = 32bit
        int i  = 0b0_1111111_11111111_11111111_11111111;
        int i_ = 0b1_0000000_00000000_00000000_00000000;
        // 8byte = 64bit
        long l  = 0b0_1111111_11111111_11111111_11111111_11111111_11111111_11111111_11111111L;
        long l_ = 0b1_0000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000L;

        System.out.println(b);
        System.out.println(b_);
        System.out.println(s);
        System.out.println(s_);
        System.out.println(i);
        System.out.println(i_);
        System.out.println(l);
        System.out.println(l_);

        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);

    }

    //字节测试
    @Test
    public void byteTest(){

        byte a1 = 'A';
        short a2 = '啊';

        System.out.println(a1);
        System.out.println(a2);

        char c1 = 'A';
        char c2 = '啊';

        System.out.println(c1);
        System.out.println(c2);

        int i1 = 'A';
        int i2 = '啊';
        System.out.println(i1);
        System.out.println(i2);


        String s1 = "A";
        String s2 = "啊";

        byte [] s1_ = s1.getBytes();
        byte [] s2_ = s2.getBytes();

        System.out.println(s1);
        for (byte b: s1_){
            System.out.println(b);
        }

        System.out.println(s2);
        for (byte b: s2_){
            System.out.println(b);
        }
    }

    //浮点测试
    @Test
    public void floatTest(){
        float f = 1.5f;
        double d = 1.5;
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(f)));
        System.out.println(Long.toBinaryString(Double.doubleToLongBits(d)));

        f = -1.5f;
        d = -1.5d;
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(f)));
        System.out.println(Long.toBinaryString(Double.doubleToLongBits(d)));

        f = 1.234e2f;
        d = 1.234e2;
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(f)));
        System.out.println(Long.toBinaryString(Double.doubleToLongBits(d)));
    }

}
