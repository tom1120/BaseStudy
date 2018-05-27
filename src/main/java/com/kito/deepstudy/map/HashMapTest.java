package com.kito.deepstudy.map;/**
 * Created by hasee on 2016/10/24.
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 分拣存储
 * 比如统计单词出现的次数
 * this is cat and and that is mice and where is the food ?
 * 1、分割字符串
 * 2、分拣存储
 * 3、统计单词出现次数
 * @author zhaoyi
 * @createTime 2016-10-2016/10/24-20:40
 */
public class HashMapTest {

    public static void main(String[] args) {
        //分割字符串
        String[] arr="this is cat and and that is mice and where is the food ?".split(" ");
        //分拣存储
        Map<String,Integer> map=new HashMap<String,Integer>();
        for(String key:arr){
//            System.out.println(key);
            if(!map.containsKey(key)){
                map.put(key,1);
            }else {
                map.put(key,map.get(key)+1);
            }
        }

        Set<String> stringSet=map.keySet();
        Iterator<String> it=stringSet.iterator();

        while (it.hasNext()){
            String key=it.next();
            Integer value=map.get(key);
            System.out.println(key+"= [" + value + "]");
        }


    }

}

