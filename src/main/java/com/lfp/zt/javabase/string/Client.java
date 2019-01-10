package com.lfp.zt.javabase.string;

import java.nio.charset.StandardCharsets;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2019-01-04
 * Copyright: Copyright (c) 2019
 * Company:
 *
 * @author ZhuTao
 * @version 2.0
 */
public class Client {

    public static void main(String[] args){
        StringBuilder sb = new StringBuilder().append("Hello").append(" ").append("World");
        System.out.println(sb.toString());


        byte[] bytes = new byte[16];
        String s = new String(bytes, StandardCharsets.US_ASCII);
        System.out.println(s);
    }

}
