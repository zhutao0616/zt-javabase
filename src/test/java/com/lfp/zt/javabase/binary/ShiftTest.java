package com.lfp.zt.javabase.binary;

import org.junit.Test;

/**
 * Project: zt-javabase
 * Title: 测试字符的位运算
 * Description: 字符字节的位运算，与或非等操作
 * Date: 2018-4-12
 * Copyright: Copyright (c) 2018
 * Company: LFP
 *
 * @author ZhuTao
 * @version 1.0
 */
public class ShiftTest {

    //按位非 ~
    @Test
    public void testNot(){
        int b1  = 0b0_1111111_11111111_11111111_11111111;
        int b2  = 0b1_0000000_00000000_00000000_00000000;
        int b3 = ~b1;
        int b4 = ~b2;

        System.out.println(b1);//0_1111111_11111111_11111111_11111111
        System.out.println(b3);//1_0000000_00000000_00000000_00000000

        System.out.println(b2);//1_0000000_00000000_00000000_00000000
        System.out.println(b4);//0_1111111_11111111_11111111_11111111
    }

    //按位与 &
    @Test
    public void testAnd(){
        int b1  = 0b0_1111111_11111111_11111111_11111111;
        int b2  = 0b1_0000000_00000000_00000000_00000000;
        int b3 = b1 & b2;

        System.out.println(b1);//0_1111111_11111111_11111111_11111111
        System.out.println(b2);//1_0000000_00000000_00000000_00000000
        System.out.println(b3);//0_0000000_00000000_00000000_00000000
    }

    //按位或 |
    @Test
    public void testOr(){
        int b1  = 0b0_1111111_11111111_11111111_11111111;
        int b2  = 0b1_0000000_00000000_00000000_00000000;
        int b3 = b1 | b2;

        System.out.println(b1);//0_1111111_11111111_11111111_11111111
        System.out.println(b2);//1_0000000_00000000_00000000_00000000
        System.out.println(b3);//1_1111111_11111111_11111111_11111111
    }

    //按位异或 ^
    @Test
    public void testXor(){
        int b1  = 0b0_1111111_11111111_11111111_11111111;
        int b2  = 0b1_0000000_00000000_00000000_00000000;
        int b3 = b1 ^ b2;

        System.out.println(b1);//0_1111111_11111111_11111111_11111111
        System.out.println(b2);//1_0000000_00000000_00000000_00000000
        System.out.println(b3);//1_1111111_11111111_11111111_11111111
    }

    //算术左移 << 高位溢出，低位补零
    @Test
    public void testLeft(){
        int b1  = 0b0_1111111_11111111_11111111_11111111;
        int b2  = 0b1_0000000_00000000_00000000_00000000;
        int b3 = b1<<1;
        int b4 = b2<<1;

        System.out.println(b1);//0_1111111_11111111_11111111_11111111
        System.out.println(b3);//_1111111_11111111_11111111_111111110

        System.out.println(b2);//1_0000000_00000000_00000000_00000000
        System.out.println(b4);//_0000000_00000000_00000000_000000000
    }

    //算术右移 >> 低位溢出，符号位不变，并用符号位补溢出的高位
    @Test
    public void testRight(){
        int b1  = 0b0_1111111_11111111_11111111_11111111;
        int b2  = 0b1_0000000_00000000_00000000_00000000;
        int b3 = b1>>1;
        int b4 = b2>>1;

        System.out.println(b1);//0_1111111_11111111_11111111_11111111
        System.out.println(b3);//00_1111111_11111111_11111111_1111111

        System.out.println(b2);//1_0000000_00000000_00000000_00000000
        System.out.println(b4);//11_0000000_00000000_00000000_0000000
    }

    //逻辑右移 >> 低位溢出，高位补零
    @Test
    public void testRightNoSymbol(){
        int b1  = 0b0_1111111_11111111_11111111_11111111;
        int b2  = 0b1_0000000_00000000_00000000_00000000;
        int b3 = b1>>>1;
        int b4 = b2>>>1;

        System.out.println(b1);//0_1111111_11111111_11111111_11111111
        System.out.println(b3);//00_1111111_11111111_11111111_1111111

        System.out.println(b2);//1_0000000_00000000_00000000_00000000
        System.out.println(b4);//01_0000000_00000000_00000000_0000000
    }


    //左移乘法
    @Test
    public void testMultiplication(){
        int b1  = 0b0_0000000_00000000_00000000_00001000;//8
        int b2  = 0b1_1111111_11111111_11111111_11111000;//-8
        int b3 = b1 << 2;
        int b4 = b2 << 2;

        System.out.println(b1);//0_0000000_00000000_00000000_00001000
        System.out.println(b3);//0_00000_00000000_00000000_0000100000

        System.out.println(b2);//1_1111111_11111111_11111111_11111000
        System.out.println(b4);//1_11111_11111111_11111111_1111100000
    }

    //右移除法
    @Test
    public void testDivision(){
        int b1  = 0b0_0000000_00000000_00000000_00001000;//8
        int b2  = 0b1_1111111_11111111_11111111_11111000;//-8
        int b3 = b1 >> 2;
        int b4 = b2 >> 2;

        System.out.println(b1);//0_0000000_00000000_00000000_00001000
        System.out.println(b3);//0_000000000_00000000_00000000_000010

        System.out.println(b2);//1_1111111_11111111_11111111_11111000
        System.out.println(b4);//1_111111111_11111111_11111111_111110
    }

    //与1判奇偶
    @Test
    public void testOddEven(){
        int a = 5;
        int b = 6;
        System.out.println(a+((a&1)==1?"奇数":"偶数"));
        System.out.println(b+((b&1)==1?"奇数":"偶数"));
    }

    //异或交换
    @Test
    public void testSwap(){
        int b1  = 0b0_0000000_00000000_00000000_00001000;//8
        int b2  = 0b1_1111111_11111111_11111111_11111000;//-8

        System.out.println(b1); //0_0000000_00000000_00000000_00001000
        System.out.println(b2); //1_1111111_11111111_11111111_11111000

        b1 = b1 ^ b2;           //1_1111111_11111111_11111111_11110000
        b2 = b1 ^ b2;           //0_0000000_00000000_00000000_00001000
        b1 = b1 ^ b2;           //1_1111111_11111111_11111111_11111000

        System.out.println(b1); //1_1111111_11111111_11111111_11111000
        System.out.println(b2); //0_0000000_00000000_00000000_00001000


        int c1 = 38;
        int c2 = -986;

        System.out.println(c1);
        System.out.println(c2);

        c1 = c1 ^ c2;
        c2 = c1 ^ c2;
        c1 = c1 ^ c2;

        System.out.println(c1);
        System.out.println(c2);

    }

    //移位求绝对值
    @Test
    public void testAbsolute (){
        int c1 = 38;
        int c2 = -986;

        System.out.println(c1);
        System.out.println(c2);

        System.out.println(c1>>31);
        System.out.println(c2>>31);

        c1 = (c1^(c1>>31))-(c1>>31);//c1 ^ 0 + 0
        c2 = (c2^(c2>>31))-(c2>>31);//c2 ^-1 + 1

        System.out.println(c1);
        System.out.println(c2);
    }

}
