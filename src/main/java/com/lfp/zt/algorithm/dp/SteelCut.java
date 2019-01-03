package com.lfp.zt.algorithm.dp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class SteelCut {

    private static final int [] price = {0,1,5,8,9,10,17,17,20,24,30};
    private static List<Integer> best = new ArrayList<>();

    private int recursiveCut(int [] price, int n){
        if (n==0) return 0;
        int p = Integer.MIN_VALUE;
        for (int i=1;i<=Math.min(n,10);i++){
            p = Math.max(p, price[i]+recursiveCut(price, n-i));
        }
        return p;
    }

    private int recordCut(int [] price, int [] best, int n){
        if (n==0) {
            best[0]=0;
            return 0;
        }
        if (best[n]!=0) return best[n];
        int p = Integer.MIN_VALUE;
        for (int i=1;i<=Math.min(n,10);i++){
            p = Math.max(p, price[i]+recordCut(price, best, n-i));
        }
        best[n] = p;
        return p;
    }

    private int dynamicCut(int [] price, int [][] best, int n){
        for (int j=1;j<=n;j++){
            int p = Integer.MIN_VALUE;
            int count = 0;
            for (int i=1;i<=Math.min(j,10);i++){
                if (price[i]+best[j-i][0]>p){
                    p = price[i]+best[j-i][0];
                    count = i;
                }
            }
            best[j][0] = p;
            best[j][count] = 1;
        }
        for (int j=1;j<=n;j++){
            for (int i=1;i<=j;i++){
                System.out.print(best[j][i]+",");
            }
            System.out.println();
        }
        return best[n][0];
    }

    public static void main(String[] args){
        SteelCut steelCut = new SteelCut();
        int n = 10;
        Date begin = new Date();
        int p = steelCut.recursiveCut(price, n);
        System.out.println("递归耗时："+(new Date().getTime()-begin.getTime())+"ms");
        System.out.println(p);

        begin = new Date();
        int[] best = new int[n+1];
        p = steelCut.recordCut(price, best, n);
        System.out.println("记录耗时："+(new Date().getTime()-begin.getTime())+"ms");
        System.out.println(p);

        begin = new Date();
        int[][] all = new int[n+1][n+1];
        p = steelCut.dynamicCut(price, all, n);
        System.out.println("DP耗时："+(new Date().getTime()-begin.getTime())+"ms");
        System.out.println(p);

    }

}
