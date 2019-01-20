package com.lfp.zt.javabase.binary;

import org.junit.Assert;
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
        int b1  = 0b0_1111111_11111111_11111111_11111111;   //Integer.MAX_VALUE
        int b2  = 0b1_0000000_00000000_00000000_00000000;   //Integer.MIN_VALUE
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

    //算术左移 << 高位溢出，低位补零(移1位相当于*2，溢出不算)
    @Test
    public void testLeft(){
        int b1  = 0b0_1111111_11111111_11111111_11111111;
        int b2  = 0b1_0000000_00000000_00000000_00000000;
        int b3 = b1<<1;
        int b4 = b2<<1;

        System.out.println(b1);//0_1111111_11111111_11111111_11111111
        System.out.println(b3);//1_1111111_11111111_11111111_11111110

        System.out.println(b2);//1_0000000_00000000_00000000_00000000
        System.out.println(b4);//0_0000000_00000000_00000000_00000000
    }

    //算术右移 >> 低位溢出，符号位不变，并用符号位补溢出的高位(移1位相当于/2)
    @Test
    public void testRight(){
        int b1  = 0b0_1111111_11111111_11111111_11111111;
        int b2  = 0b1_0000000_00000000_00000000_00000000;
        int b3 = b1>>1;
        int b4 = b2>>1;

        System.out.println(b1);//0_1111111_11111111_11111111_11111111
        System.out.println(b3);//0_0111111_11111111_11111111_11111111

        System.out.println(b2);//1_0000000_00000000_00000000_00000000
        System.out.println(b4);//1_1000000_00000000_00000000_00000000
    }

    //逻辑右移 >>> 低位溢出，高位补零，无符号右移(移1位相当于/2，不算符号)
    @Test
    public void testRightNoSymbol(){
        int b1  = 0b0_1111111_11111111_11111111_11111111;
        int b2  = 0b1_0000000_00000000_00000000_00000000;
        int b3 = b1>>>1;
        int b4 = b2>>>1;

        System.out.println(b1);//0_1111111_11111111_11111111_11111111
        System.out.println(b3);//0_0111111_11111111_11111111_11111111

        System.out.println(b2);//1_0000000_00000000_00000000_00000000
        System.out.println(b4);//0_1000000_00000000_00000000_00000000
    }


    //左移乘法
    @Test
    public void testMultiplication(){
        int b1  = 0b0_0000000_00000000_00000000_00001000;//8
        int b2  = 0b1_1111111_11111111_11111111_11111000;//-8
        int b3 = b1 << 2;
        int b4 = b2 << 2;

        System.out.println(b1);//0_0000000_00000000_00000000_00001000
        System.out.println(b3);//0_0000000_00000000_00000000_00100000

        System.out.println(b2);//1_1111111_11111111_11111111_11111000
        System.out.println(b4);//1_1111111_11111111_11111111_11100000
    }

    //右移除法
    @Test
    public void testDivision(){
        int b1  = 0b0_0000000_00000000_00000000_00001000;//8
        int b2  = 0b1_1111111_11111111_11111111_11111000;//-8
        int b3 = b1 >> 2;
        int b4 = b2 >> 2;

        System.out.println(b1);//0_0000000_00000000_00000000_00001000
        System.out.println(b3);//0_0000000_00000000_00000000_00000010

        System.out.println(b2);//1_1111111_11111111_11111111_11111000
        System.out.println(b4);//1_1111111_11111111_11111111_11111110
    }

    //与1判奇偶
    @Test
    public void testOddEven(){
        int a = 5;
        int b = 6;
        System.out.println(a+checkOddEven(a));
        System.out.println(b+checkOddEven(b));
    }
    //奇偶判定其实只要取最后一位，若是1为奇数，若是0为偶数，高位全部掩盖掉即可。
    private String checkOddEven(int num){
        return (num & 1) == 1 ? "奇数":"偶数";
    }

    //异或交换
    // a^0 == a;
    // a^-1 == ~a;
    // a^a == 0;
    // a^b == b^a;
    // b1^b2^b2 == b1;
    // b1^b2^b1 == b2;
    @Test
    public void testSwap(){
        int b1  = 0b0_0000000_00000000_00000000_00001000;//8
        int b2  = 0b1_1111111_11111111_11111111_11111000;//-8

        System.out.println(b1); //0_0000000_00000000_00000000_00001000
        System.out.println(b2); //1_1111111_11111111_11111111_11111000

        System.out.println(b1^0);
        System.out.println(b1^-1);
        System.out.println(b1^b1);
        System.out.println(b1^b2);
        System.out.println(b2^b1);

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

    //移位和异或求绝对值
    // a^0 == a;
    // a^-1 == ~a;
    // -a == ~a+1 == a^-1+1 == a^(-1)-(-1)
    //  a == a^0  == a^ 0+0 == a^( 0)-( 0)
    // 只要取到值的符号就可以通过异或操作获得绝对值
    @Test
    public void testAbsolute (){
        int c1 = 38;
        int c2 = -986;

        System.out.println(c1);
        System.out.println(c2);

        System.out.println(c1>>31); //符号位 0
        System.out.println(c2>>31); //符号位 -1

        c1 = (c1^(c1>>31))-(c1>>31);//c1 ^ 0 - 0
        c2 = (c2^(c2>>31))-(c2>>31);//c2 ^-1 - -1

        System.out.println(c1);
        System.out.println(c2);
    }

    @Test
    public void testShift(){
        System.out.println(1 << 1);//2
        System.out.println(1 << 2);//4
        System.out.println(1 << 3);//8
        System.out.println(1 << 4);//16
    }

    @Test
    public void test(){
        int COUNT_BITS = Integer.SIZE - 3;
        int CAPACITY   = (1 << COUNT_BITS) - 1; //0_00 11111_11111111_11111111_11111111

        int RUNNING    = -1 << COUNT_BITS;      //1_11 00000_00000000_00000000_00000000
        int SHUTDOWN   =  0 << COUNT_BITS;      //0_00 00000_00000000_00000000_00000000
        int STOP       =  1 << COUNT_BITS;      //0_01 00000_00000000_00000000_00000000
        int TIDYING    =  2 << COUNT_BITS;      //0_10 00000_00000000_00000000_00000000
        int TERMINATED =  3 << COUNT_BITS;      //0_11 00000_00000000_00000000_00000000


        Assert.assertEquals(CAPACITY,   0b0_00_11111_11111111_11111111_11111111);
        Assert.assertEquals(RUNNING,    0b1_11_00000_00000000_00000000_00000000);
        Assert.assertEquals(SHUTDOWN,   0b0_00_00000_00000000_00000000_00000000);
        Assert.assertEquals(STOP,       0b0_01_00000_00000000_00000000_00000000);
        Assert.assertEquals(TIDYING,    0b0_10_00000_00000000_00000000_00000000);
        Assert.assertEquals(TERMINATED, 0b0_11_00000_00000000_00000000_00000000);

        //高3位表示状态，低29位计数
        // state & ~CAPACITY    保留高位值，低位掩盖
        // count &  CAPACITY    保留低位值，高位掩盖
        // state | count        利用一个32位int值 ctl 保存了两个变量，高位存状态，低位存数量




    }

}
