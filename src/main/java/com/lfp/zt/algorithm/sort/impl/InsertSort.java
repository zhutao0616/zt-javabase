package com.lfp.zt.algorithm.sort.impl;

import com.lfp.zt.algorithm.sort.Sort;

/**
 * Project: zt-javabase
 * Title: 插入排序
 * Description: 每次选择一个插入到之前序列的合适位置
 * Date: 2018-12-31
 * Copyright: Copyright (c) 2018
 * Company: qudian
 *
 * @author ZhuTao
 * @version 2.0
 */
public class InsertSort<T> implements Sort<T> {
    @Override
    public T[] sort(T[] origin) {
        for(int i=1;i<origin.length;i++){
            for(int j=i;j>0;j--){
                if (compare(origin[j-1], origin[j])>0){
                    swap(origin, j-1, j);
                }
            }
        }
        return origin;
    }
}
