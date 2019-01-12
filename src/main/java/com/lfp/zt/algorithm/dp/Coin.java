package com.lfp.zt.algorithm.dp;

import java.util.Arrays;

/**
 * Project: zt-javabase
 * Title: 最少硬币找零问题
 * Description: 构造状态转移方程beat[i]=j，表示在面对总价值为i时，可以凑成的最小硬币数量为j
 *              对于每种硬币k，都有取和不取两种情况，
 * Date: 2019-01-10
 * Copyright: Copyright (c) 2019
 * Company:
 *
 * @author ZhuTao
 * @version 2.0
 */
public class Coin {
    private static final int [] price = {0,2,5,8,9,10,17,17,20,24,30};

    private int dpCoin(int max){
        //best[i]表示总值为i时，所需要在最小硬币数量
        int [] best = new int[max+1];
        for (int i=1;i<=max;i++){//i=3,k=1,price[k]=2,best[i - price[k]=best[1]=-1
            best[i] = -100000;
            for (int k=1;k<price.length;k++){
                if (i-price[k]>=0) {
                    best[i] = Math.max(best[i - price[k]] + 1, best[i]);
                }
            }
        }
        System.out.println(Arrays.toString(best));
        return best[max];
    }

    public static void main(String[] args){
        Coin coin = new Coin();
        System.out.println(coin.dpCoin(10));
    }
}
