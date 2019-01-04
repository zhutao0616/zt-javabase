package com.lfp.zt.algorithm.sort.impl;

import com.lfp.zt.algorithm.sort.Sort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Project: zt-javabase
 * Title: 分治排序
 * Description: 将大任务拆分成多个子任务进行，当长度过小时候直接排序，否则拆分成多个任务进行。
 * Date: 2019-01-04
 * Copyright: Copyright (c) 2019
 * Company:
 *
 * @author ZhuTao
 * @version 2.0
 */
public class ForkJoinSort<T> extends RecursiveAction implements Sort<T> {

    private T[] array;
    private int lo, hi;
    private static final int THRESHOLD = 100;

    public ForkJoinSort() {
    }

    public ForkJoinSort(T[] array, int lo, int hi) {
        this.array = array;
        this.lo = lo;
        this.hi = hi;
    }

    @Override
    public T[] sort(T[] origin) {
        ForkJoinPool.commonPool().invoke(new ForkJoinSort<>(origin, 0, origin.length));
        return origin;
    }

    @Override
    protected void compute() {
        if (hi - lo < THRESHOLD)
            Arrays.sort(array, lo, hi);
        else {
            int mid = (lo + hi) >>> 1;
            // 数组长度大于1000，将数组平分为两份
            // 由两个子任务进行排序
            ForkJoinSort<T> left = new ForkJoinSort<>(array, lo, mid);
            ForkJoinSort<T> right = new ForkJoinSort<>(array, mid, hi);
            invokeAll(left, right);
            // 排序完成后合并排序结果
            merge(lo, mid, hi);
        }
    }

    private void merge(int lo, int mid, int hi) {
        T[] buf = Arrays.copyOfRange(array, lo, mid);
        for (int i = 0, j = lo, k = mid; i < buf.length; j++) {
            if (k == hi || compare(buf[i], array[k])<0) {
                array[j] = buf[i++];
            } else {
                array[j] = array[k++];
            }
        }
    }


}
