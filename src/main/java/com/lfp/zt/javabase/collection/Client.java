package com.lfp.zt.javabase.collection;

import java.util.*;

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

    public static void main(String[] args){
        test();
    }

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
    }

    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static void test(){

        //map.red

        List<Integer> list = new LinkedList<>();
        list.add(1);list.add(2);list.add(3);list.add(4);

        /*list.forEach(obj->{
            if (obj.equals(2)) list.remove(obj);
        });*/

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer obj = iterator.next();
            if (obj.equals(2)) iterator.remove();
            if (obj.equals(4)) iterator.remove();
        }
        System.out.println(list.size());
    }


}
