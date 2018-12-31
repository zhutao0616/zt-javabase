package com.lfp.zt.algorithm.sort;

import com.lfp.zt.algorithm.sort.impl.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2018-12-31
 * Copyright: Copyright (c) 2018
 * Company: qudian
 *
 * @author ZhuTao
 * @version 2.0
 */
public class SortTest {

    List<Integer> origin = new ArrayList<>();

    private void print(List<Integer> origin){
        for (Integer integer : origin){
            System.out.print(integer+",");
        }
        System.out.println();
    }

    private void print(Sort<Integer> sort){
        Date begin = new Date();
        List<Integer> result = (List<Integer>) sort.sort(origin);
        System.out.println(sort.getClass().getSimpleName()+"耗时："+(new Date().getTime()-begin.getTime())+"ms");
        print(result);
    }


    @Before
    public void init(){
        int max = 99999;
        int min = 10000;
        Random random = new Random();
        for (int i=0;i<10000;i++){
            origin.add(random.nextInt(max)%(max-min+1) + min);
        }
        //print(origin);
    }



    @Test
    public void testBubbleSort(){
        Sort<Integer> sort;
        // 冒泡
        sort = new BubbleSort<>();
        print(sort);
    }
    @Test
    public void testSelectionSort(){
        Sort<Integer> sort;
        // 选择
        sort = new SelectionSort<>();
        print(sort);
    }
    @Test
    public void testInsertSort(){
        Sort<Integer> sort;
        // 插入
        sort = new InsertSort<>();
        print(sort);
    }
    @Test
    public void testMergeSort(){
        Sort<Integer> sort;
        // 归并
        sort = new MergeSort<>();
        print(sort);
    }
    @Test
    public void testQuickSort(){
        Sort<Integer> sort;
        // 快速
        sort = new QuickSort<>();
        print(sort);
    }
    @Test
    public void testHeapSort(){
        Sort<Integer> sort;
        // 堆排
        sort = new HeapSort<>();
        print(sort);
    }
}
