package com.kito.thread.secordskill;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoyipc on 2021-04-27.
 */
public class RedisTest {

    private static Jedis jedis = null;

    public static void main(String[] args) {
        jedis = new Jedis("127.0.0.1",6379);
        jedis.auth("paascloud@redis");
        setString();
//        setMap();
    }

    public static void setString(){
        jedis.set("name8","刘一");
        System.out.println("添加成功..");
    }

    public static void setMap(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("赵九","15000");
        map.put("刘十一","20000");
        jedis.hmset("jiuyeMap",map);
        System.out.println("添加成功..");
    }

    public static void setList(){
        jedis.lpush("zhangs1","10000");
        jedis.lpush("zhangs1","15000");
    }

    public static void setSet(){
        jedis.sadd("lisi1","12000");
        jedis.sadd("lisi1","13000");
        jedis.sadd("lisi1","14000");
    }

}
