package com.kito.thread.secordskill;

import redis.clients.jedis.Jedis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 秒杀：很多人抢少量的商品的过程
 * redis 测试抢购
 */
public class RedisSecKillTest {
    public static void main(String[] args) {

        final String watchKeys = "watchkeys";
        ExecutorService executor = Executors.newFixedThreadPool(20);
        final Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.auth("paascloud@redis");
        jedis.set(watchKeys,"0");// 重置watchkeys为0
        jedis.del("setsucc","setfail");// 清空抢成功的，与没有成功的
        jedis.close();

        for (int i = 0; i <10000 ; i++) {// 测试一万人同时访问
            executor.execute(new MyRunnable());
        }
        executor.shutdown();
    }

}
