package com.lfp.zt.algorithm.dp;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2019-01-01
 * Copyright: Copyright (c) 2019
 * Company: LFP
 *
 * @author ZhuTao
 * @version 2.0
 */
public class LCS {

    /**
     * 最长公共子序列
     * 取c[i][j]表示截至字符串1到i长度，字符串2到j长度，两者的最大公共子序列长度
     * 字符相同，继续累加；字符不同，分别加一个字符取最大值
     * @param str1  字符串1
     * @param str2  字符串2
     * @return len  公共子序列长度
     */
    public static int lcs(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] c = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for( int j = 0; j <= len2; j++) {
                if(i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1] + 1;
                } else {
                    c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
                }
            }
        }
        return c[len1][len2];
    }

    /**
     * 最长公共子字符串
     * 取c[i][j]表示截至字符串1到i长度，字符串2到j长度，两者当前公共子串长度
     * 字符相同，继续累加；字符不同，子串重选
     * @param str1  字符串1
     * @param str2  字符串2
     * @return len  公共子串长度
     */
    public static int lcss(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int result = 0;     //记录最长公共子串长度
        int[][] c = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for( int j = 0; j <= len2; j++) {
                if(i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1] + 1;
                    result = Math.max(c[i][j], result);
                } else {
                    c[i][j] = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        String str1 = "android";
        String str2 = "random";

        System.out.println("最长公共子序列长度："+lcs(str1,str2));
        System.out.println("最长公共子串长度："+lcss(str1,str2));
    }
}
