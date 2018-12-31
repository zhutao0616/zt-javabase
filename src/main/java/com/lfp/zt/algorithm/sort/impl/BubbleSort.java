package com.lfp.zt.algorithm.sort.impl;

import com.lfp.zt.algorithm.sort.Sort;

/**
 * Project: zt-javabase
 * Title: 冒泡排序
 * Description: 每次两两比较，将大的交换到后面
 * Date: 2018-12-31
 * Copyright: Copyright (c) 2018
 * Company: qudian
 *
 * @author ZhuTao
 * @version 2.0
 */
public class BubbleSort<T> implements Sort<T> {

    @Override
    public T[] sort(T[] origin) {
        for(int i=0;i<origin.length-1;i++){
            for(int j=0;j<origin.length-1-i;j++){
                if (compare(origin[j], origin[j+1])>0){
                    swap(origin, j, j+1);
                }
            }
        }
        return origin;
    }

}
