package com.lfp.zt.algorithm.dp;

/**
 * Project: zt-javabase
 * Title:
 * Description:
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
        for (int i=1;i<=max;i++){
            best[i] = Integer.MAX_VALUE;
            for (int k=1;k<=price.length-1;k++){
                if (i-price[k]>=0) {
                    best[i] = Math.min(best[i - price[k]] + 1, best[i]);
                }
            }
        }
        return best[max];
    }

    public static void main(String[] args){
        Coin coin = new Coin();
        System.out.println(coin.dpCoin(100));
    }
}
