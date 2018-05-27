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
public class HashMapTestTwo {

    public static void main(String[] args) {
        //分割字符串
        String[] arr="this is cat and and that is mice and where is the food ?".split(" ");
        //分拣存储
        Map<String,Letter> map=new HashMap<String,Letter>();
        for(String key:arr){
//            System.out.println(key);
            if(!map.containsKey(key)){
                map.put(key,new Letter(key,1));
            }else {
                Letter count=map.get(key);
                count.setLetternum(count.getLetternum()+1);
                map.put(key,count);
            }
        }

        for(String key:map.keySet()){
            Letter value=map.get(key);
            System.out.println(key+"args = [" + value.getLetternum() + "]");
        }


    }

}

