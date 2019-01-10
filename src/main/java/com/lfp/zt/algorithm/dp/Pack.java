package com.lfp.zt.algorithm.dp;

import java.util.Arrays;

/**
 * Project: zt-javabase
 * Title: 0-1背包
 * Description: 物品是否装入，且只能装一次。构造递归函数：
 *              m[i][j]表示：在面对第i件物品，背包剩余容量为j时，所能获得的最大价值
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

    private int dpPack(int num, int max){
        // 面对第i件物品，背包剩余容量为j时，所能获得的最大价值
        int [][] m = new int[num+1][max+1];

        for (int i=1;i<=num;i++){
            for (int j=1;j<=max;j++){
                if (j<weight[i]){
                    // 已经装不下了
                    m[i][j] = m[i-1][j];
                }else{
                    m[i][j] = Math.max(m[i-1][j-weight[i]]+price[i], m[i-1][j]);
                }
            }
        }

        Arrays.stream(m).forEach(row->{
            Arrays.stream(row).forEach(cell->System.out.print(String.format("%2d ", cell)));
            System.out.println();
        });

        return m[num][max];
    }

    public static void main(String[] args){
        Pack pack = new Pack();
        System.out.println(pack.dpPack(6, 20));
    }


}
