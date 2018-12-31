package com.lfp.zt.algorithm.sort.impl;

import com.lfp.zt.algorithm.sort.Sort;

/**
 * Project: zt-javabase
 * Title: 选择排序
 * Description: 每次选取剩余中最小的放到当前位置
 * Date: 2018-12-31
 * Copyright: Copyright (c) 2018
 * Company: qudian
 *
 * @author ZhuTao
 * @version 2.0
 */
public class SelectionSort<T> implements Sort<T> {

    @Override
    public T[] sort(T[] origin) {
        for(int i=0;i<origin.length-1;i++){
            for(int j=i+1;j<origin.length;j++){
                if (compare(origin[i], origin[j])>0){
                    swap(origin, i, j);
                }
            }
        }
        return origin;
    }

}
