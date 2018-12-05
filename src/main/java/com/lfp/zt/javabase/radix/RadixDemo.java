package com.lfp.zt.javabase.radix;

/**
 * Project: zt-javabase
 * Title:各种进制字面量举例
 * Description:
 * Date: 2018-12-04
 * Copyright: Copyright (c) 2018
 * Company: LFP
 *
 * @author ZhuTao
 * @version 2.0
 */
public class RadixDemo {

    /**
     * 二进制
     */
    private void binary(){
        //byte 1 Byte，8 bit
        byte ba = (byte) 0b0000_0001;
        byte bb = (byte) 0b1111_1111;
        byte bc = (byte) 0b0111_1111;
        byte bd = (byte) 0b1000_0000;
        System.out.println("ba="+ba);
        System.out.println("bb="+bb);
        System.out.println("bc="+bc);
        System.out.println("bd="+bd);

        //short 2 Byte，16 bit
        short sa = (short) 0b0000_0000_0000_0001;
        short sb = (short) 0b1111_1111_1111_1111;
        short sc = (short) 0b0111_1111_1111_1111;
        short sd = (short) 0b1000_0000_0000_0000;
        System.out.println("sa="+sa);
        System.out.println("sb="+sb);
        System.out.println("sc="+sc);
        System.out.println("sd="+sd);

        //int 4 Byte，32 bit
        int ia = 0b0000_0000_0000_0000_0000_0000_0000_0001;  //
        int ib = 0b1111_1111_1111_1111_1111_1111_1111_1111;  //补码表示负数，反码+1
        int ic = 0b0111_1111_1111_1111_1111_1111_1111_1111;  //
        int id = 0b1000_0000_0000_0000_0000_0000_0000_0000;  //补码表示负数，反码+1
        System.out.println("ia="+ia);
        System.out.println("ib="+ib);
        System.out.println("ic="+ic);
        System.out.println("id="+id);

        //long 8 Byte，64 bit
        long la = 0b0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0001L;
        long lb = 0b1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111L;
        long lc = 0b0111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111L;
        long ld = 0b1000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000L;
        System.out.println("la="+la);
        System.out.println("lb="+lb);
        System.out.println("lc="+lc);
        System.out.println("ld="+ld);
    }

    /**
     * 十六进制
     */
    private void hex(){
        byte ba = (byte) 0x01;
        byte bb = (byte) 0xff;
        byte bc = (byte) 0x7f;
        byte bd = (byte) 0x80;
        System.out.println("ba="+ba);
        System.out.println("bb="+bb);
        System.out.println("bc="+bc);
        System.out.println("bd="+bd);
    }

    public static void main(String[] args){
        RadixDemo demo = new RadixDemo();
        demo.binary();
        demo.hex();
    }

}
