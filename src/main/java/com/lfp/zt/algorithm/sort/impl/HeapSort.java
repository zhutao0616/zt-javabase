package com.lfp.zt.algorithm.sort.impl;

import com.lfp.zt.algorithm.sort.Sort;

/**
 * Project: zt-javabase
 * Title: 堆排序
 * Description: 构建一个大顶堆，然后第一个就是最大值，替换到最后，继续将剩下的构建大顶堆，继续直到最后
 * Date: 2018-12-31
 * Copyright: Copyright (c) 2018
 * Company: qudian
 *
 * @author ZhuTao
 * @version 2.0
 */
public class HeapSort<T> implements Sort<T> {
    @Override
    public T[] sort(T[] origin) {
        heapCreate(origin);
        for (int i=origin.length-1;i>0;i--){
            swap(origin, 0, i);
            heapUpdate(origin, 0, i);
        }
        return origin;
    }

    private void heapCreate(T[] origin){
        for (int i=origin.length/2;i>0;i--){
            heapUpdate(origin, i-1, origin.length);
        }
    }

    private void heapUpdate(T[] origin, int i, int len){
        int leftCount = 2*i+1;
        int rightCount = 2*i+2;
        int bigCount = i;
        if (leftCount<len && compare(origin[leftCount], origin[bigCount])>0){
            bigCount = leftCount;
        }
        if (rightCount<len && compare(origin[rightCount], origin[bigCount])>0){
            bigCount = rightCount;
        }
        if (bigCount != i){
            swap(origin, i, bigCount);
            heapUpdate(origin, bigCount, len);
        }
    }


}
