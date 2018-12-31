package com.lfp.zt.algorithm.sort.impl;

import com.lfp.zt.algorithm.sort.Sort;

/**
 * Project: zt-javabase
 * Title: 快速排序
 * Description: 选取第一个值作为参考值，一次遍历将所有小的放在左边，大的放在右边，然后将该参考值放在临界位置
 *              根据临界位置，将数组分为两段，继续递归排序，直到数组长度为1
 * Date: 2018-12-31
 * Copyright: Copyright (c) 2018
 * Company: qudian
 *
 * @author ZhuTao
 * @version 2.0
 */
public class QuickSort<T> implements Sort<T> {
    @Override
    public T[] sort(T[] origin) {
        quick(origin, 0, origin.length-1);
        return origin;
    }

    private void quick(T[] origin, int beg, int end){
        if (beg>=end) return;
        int firstBigCount = beg+1;
        for (int i=beg+1; i<=end;i++){
            if (compare(origin[i], origin[beg])<0){
                swap(origin, i, firstBigCount++);
            }
        }
        swap(origin, beg, firstBigCount-1);
        //递归
        quick(origin, beg, firstBigCount-2);
        quick(origin, firstBigCount, end);
    }
}
