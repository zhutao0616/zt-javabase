package com.lfp.zt.algorithm.recursion;

/**
 * Project: zt-javabase
 * Title: N皇后问题
 * Description: 在N*N的棋盘中放置N个皇后，保证横竖斜无重复，最多多少种可能。
 *              经典的递归回溯问题，越早回溯，性能越好。
 * Date: 2019-01-09
 * Copyright: Copyright (c) 2019
 * Company:
 *
 * @author ZhuTao
 * @version 2.0
 */
public class NQueen {

    private int number;
    private int count = 0;
    private int num = 1;

    private NQueen(int number) {
        this.number = number;
    }

    private void run(){
        long begin = System.currentTimeMillis();
        //初始化棋盘
        int [][] chess = new int[this.number][this.number];
        //从第一行开始放置
        putQueenAtRow(chess, 0);
        long end = System.currentTimeMillis();
        System.out.println("解决 " +this.number+ " 皇后问题，" +
                "用时：" + (end - begin) + "毫秒，" +
                "计算结果："+count+"，" +
                "拷贝棋盘："+num);
    }

    /**
     * 从棋盘的第 row 行开始放置，之前的都没有问题
     * @param chess     整体棋盘
     * @param row       当前放置行
     */
    private void putQueenAtRow(int[][] chess, int row) {
        // 如果放置到最后一行，表示生成了一种解法，直接返回
        if(row == this.number){
            count++;
            System.out.println("第 "+ count +" 种解：");
            for(int i=0;i<this.number;i++){
                for(int j=0;j<this.number;j++){
                    System.out.print(chess[i][j]+" ");
                }
                System.out.println();
            }
            return;
        }

        //复制一个棋盘用来做尝试
        int[][] chessTemp = chess.clone();
        this.num++;
        //在row行依次尝试每一列的放置，
        for(int i=0;i<this.number;i++){
            //摆放这一行的皇后，之前要清掉所有这一行摆放的记录，防止污染棋盘
            for(int j=0;j<this.number;j++) chessTemp[row][j]=0;
            //尝试才i位置放一个皇后
            chessTemp[row][i]=1;
            //如果当前位置安全，可以继续摆放下一个皇后，若不安全，继续尝试i+1的位置
            if( isSafety( chessTemp, row, i ) ){
                putQueenAtRow(chessTemp,row+1);
            }
        }
    }

    /**
     * 判断在row-col位置放置棋子是否安全
     * @param chess     整体棋盘
     * @param row       当前放置行
     * @param col       当前放置列
     * @return          是否安全
     */
    private boolean isSafety(int[][] chess, int row, int col) {
        int step=1;
        while(row-step>=0){
            //正上
            if(chess[row-step][col]==1)
                return false;
            //左上
            if(col-step>=0 && chess[row-step][col-step]==1)
                return false;
            //右上
            if(col+step<this.number && chess[row-step][col+step]==1)
                return false;
            step++;
        }
        return true;
    }


    public static void main(String[] args){
        NQueen nQueen = new NQueen(8);
        nQueen.run();
    }

}
