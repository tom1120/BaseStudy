package cn.qlong.memoryout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhaoyipc on 2021-04-23.
 */
public class ObjectEqualsAndHashCodeTest {
    public Map<Perpons, Integer> giveMap_whenEqualsAndHashCodeNotOverridden_thenMemoryLeak(){
        Map<Perpons,Integer> map=new HashMap<>();
        for (int i = 0; i < 100; i++) {
            // 覆写hashcode和equals方法对象认为是一个
            map.put(new Perpons("jon"),1);
        }
        System.out.println("map.size()==1 = " + (map.size() == 1));
        return map;

    }
    public static void main(String[] args) throws IOException {
        Map<Perpons, Integer> map=new ObjectEqualsAndHashCodeTest().giveMap_whenEqualsAndHashCodeNotOverridden_thenMemoryLeak();
        boolean b=true;
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        while (b){
            String s=bufferedReader.readLine();
            System.out.println("s = " + s);
            Set<Map.Entry<Perpons,Integer>> set=map.entrySet();
            Iterator iterator=set.iterator();
            while (iterator.hasNext()){
                Map.Entry<Perpons,Integer> entry= (Map.Entry<Perpons, Integer>) iterator.next();
                Perpons perpons =entry.getKey();
                System.out.println(perpons.getName());
            }

        }
    }
}
