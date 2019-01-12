package com.lfp.zt.algorithm.dp;

import java.util.Arrays;

/**
 * Project: zt-javabase
 * Title: 背包问题
 * Description: 核心在于构造一个函数 m[i][j] 表示：面对前i件物品时，背包总容量为j时，所能获得的最大价值
 *              0-1背包，只有装和不装的情况；
 *              完全背包，需要加一层循环，尝试将物品i放置k次。
 * Date: 2019-01-09
 * Copyright: Copyright (c) 2019
 * Company:
 *
 * @author ZhuTao
 * @version 2.0
 */
public class Pack {

    private static final int [] weight = {0, 4,  6, 2, 2, 5, 1};
    private static final int [] price =  {0, 8, 10, 6, 3, 7, 2};


    private void printArray(int [][] m){
        Arrays.stream(m).forEach(row->{
            Arrays.stream(row).forEach(cell->System.out.print(String.format("%2d ", cell)));
            System.out.println();
        });
    }

    private int zeroOnePack(int num, int max){
        // j为背包可以容纳的重量，有i种物品时，向背包里添加第i种物品，所能获得的最大价值
        int [][] m = new int[num+1][max+1];

        for (int i=1;i<=num;i++){
            // 逐一扩大物品种类
            for (int j=1;j<=max;j++){
                // 逐一扩大背包大小
                if (j<weight[i]){
                    // 已经装不下了
                    m[i][j] = m[i-1][j];
                }else{
                    // 可以装得下，选择装和不装中最大收益的
                    m[i][j] = Math.max(m[i-1][j-weight[i]]+price[i], m[i-1][j]);
                }
            }
        }

        printArray(m);
        return m[num][max];
    }

    private int fullPack(int num, int max){
        // j为背包可以容纳的重量，有i种物品时，向背包里添加第i种物品，所能获得的最大价值。第i种物品可以添加的个数范围是 0<=k<=j/weight[i]
        int [][] m = new int[num+1][max+1];

        for (int i=1;i<=num;i++){
            // 逐一扩大物品种类
            for (int j=1;j<=max;j++){
                // 逐一扩大背包大小
                for (int k=0; k<=j/weight[i]; k++){
                    // 逐一尝试重复放置该物品
                    m[i][j] = Math.max(m[i-1][j-k*weight[i]]+k*price[i], m[i][j]);
                }
            }
        }

        printArray(m);
        return m[num][max];
    }

    public static void main(String[] args){
        Pack pack = new Pack();
        System.out.println(pack.zeroOnePack(6, 10));
        System.out.println(pack.fullPack(6, 10));
    }

}
