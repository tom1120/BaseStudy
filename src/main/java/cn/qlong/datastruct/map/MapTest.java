package cn.qlong.datastruct.map;

import java.util.*;

/**
 * Created by zhaoyipc on 2021-04-16.
 */
public class MapTest {
    public static void main(String[] args) {
        hashmap();
        hashtable();
    }

    private static void hashmap(){
        Map<String,String> hashMap=new HashMap<String, String>();
        hashMap.put("a","1");
        hashMap.put("b","2");
        hashMap.put(null,null);

        for (String key:hashMap.keySet()){
            System.out.println("key = " + key);
            System.out.println("value = " + hashMap.get(key));
        }

        Iterator<Map.Entry<String,String>> iterator=hashMap.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String,String> entry=iterator.next();
            System.out.println("entry key= " + entry.getKey());
            System.out.println("entry value = " + entry.getValue());
        }

        for (Map.Entry<String,String> entry:hashMap.entrySet()){
            System.out.println("entry key= " + entry.getKey());
            System.out.println("entry value = " + entry.getValue());
        }

        // 转为线程安全
        Map syncMap= Collections.synchronizedMap(hashMap);


    }


    private static void hashtable(){
        Map<String,String> table=new Hashtable<String, String>();
        // 不支持任何null值
        table.put(null,null);




    }

}
