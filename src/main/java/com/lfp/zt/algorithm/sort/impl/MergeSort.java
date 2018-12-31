package com.lfp.zt.algorithm.sort.impl;

import com.lfp.zt.algorithm.sort.Sort;

/**
 * Project: zt-javabase
 * Title: 归并排序
 * Description: 将待排序数组二分，直到只有一个值，这样就不用排序了，
 *              然后将排序好的子数组合并起来，合并的时候注意大小顺序即可。
 * Date: 2018-12-31
 * Copyright: Copyright (c) 2018
 * Company: qudian
 *
 * @author ZhuTao
 * @version 2.0
 */
public class MergeSort<T> implements Sort<T> {
    @Override
    public T[] sort(T[] origin) {
        if (origin.length<2) return origin;
        int mid = (origin.length) / 2;

        Object[] left = new Object[mid];
        Object[] right = new Object[origin.length-mid];
        System.arraycopy(origin, 0, left, 0, left.length);
        System.arraycopy(origin, mid, right, 0, right.length);
        return merge(origin, sort((T[]) left),sort((T[]) right));
    }

    private T[] merge(T[] origin, T[] left, T[] right) {
        int leftCount=0;
        int rightCount=0;
        for (int i=0;i<origin.length;i++){
            if (leftCount<left.length && rightCount<right.length){
                if (compare(left[leftCount],right[rightCount])>0){
                    origin[i] = right[rightCount++];
                }else{
                    origin[i] = left[leftCount++];
                }
            }else if (leftCount<left.length){
                origin[i] = left[leftCount++];
            }else if (rightCount<right.length){
                origin[i] = right[rightCount++];
            }else{
                System.out.println("error");
            }
        }
        return origin;
    }

}
