package com.lfp.zt.javabase.collection;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2019-01-05
 * Copyright: Copyright (c) 2019
 * Company:
 *
 * @author ZhuTao
 * @version 2.0
 */
public class Client {



    void tt(){
        HashMap<String, Object> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        map.put("1", "1");

        System.out.println(hash("1"));
        System.out.println(hash("2"));


        String key = "12345";
        System.out.println(hash(key));
        // hash值根据hashCode与无符号右移16位后 异或 得到值比较均匀
        // 在确定桶位置时候，利用桶的总数量-1 位与 hash值（等效与 hash值%总数）
        int index = (16-1) & hash(key);
        System.out.println(index);
        System.out.println(hash(key)%16);


        Collections.synchronizedMap(map);
        //map.forEach();
        map.isEmpty();
        set.isEmpty();

    }

    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static void test(){

        //map.red

        List<Integer> list = new LinkedList<>();
        list.add(1);list.add(2);list.add(3);list.add(4);

        list.forEach(obj->{
            if (obj.equals(2)) list.remove(obj);
        });

        list.isEmpty();

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer obj = iterator.next();
            if (obj.equals(2)) iterator.remove();
            if (obj.equals(4)) iterator.remove();
        }
        System.out.println(list.size());
    }





    static void failFastList(){
        List<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);

        Iterator<Integer> iterator = list.iterator();   //ArrayList.Itr
        while (iterator.hasNext()){
            Integer obj = iterator.next();
            if (obj.equals(2)) iterator.remove();       //成功
            //if (obj.equals(4)) list.remove(obj);      //失败，迭代中改变自身会报错 ConcurrentModificationException
        }
        System.out.println(list.size());

    }

    static void failSafeList(){
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);

        Iterator<Integer> iterator = list.iterator();   //CopyOnWriteArrayList.COWIterator
        while (iterator.hasNext()){
            Integer obj = iterator.next();
            //if (obj.equals(2)) iterator.remove();     //失败，不支持在迭代中删除 UnsupportedOperationException
            if (obj.equals(4)) list.remove(obj);        //成功
        }
        System.out.println(list.size());

    }

    static void queue(){
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(1);
        System.out.println(queue.peek());
        System.out.println(queue.poll());

        LinkedBlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
        blockingQueue.offer(1);
        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.poll());

        try {
            blockingQueue.put(2);
            System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    static void weakMap(){
        Map<String, Object> map = new WeakHashMap<>();
        int count = 0;
        while (true){
            map.put(String.valueOf(count++), new OOMObject());
            System.out.println(map.size());
        }
    }

    static void map(){
        Map<String, Object> map = new LinkedHashMap<>();
        int count = 0;
        while (true){
            map.put(String.valueOf(count++), new OOMObject());
            System.out.println(map.size());
        }
    }
    private static class OOMObject{
        private long[] longs = new long[10000];
    }
    public static void main(String[] args){
        map();          //会OOM
        weakMap();      //不会OOM
    }



}
