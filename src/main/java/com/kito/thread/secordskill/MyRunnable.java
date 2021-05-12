package com.kito.thread.secordskill;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.UUID;

/**
 * Created by zhaoyipc on 2021-04-27.
 */
public class MyRunnable implements Runnable {
    String watchkeys = "watchkeys";// 监视keys
    Jedis jedis = new Jedis("127.0.0.1", 6379);

    public MyRunnable() {
    }

    @Override
    public void run() {
        try {


            jedis.auth("paascloud@redis");
            jedis.watch(watchkeys);
            String val = jedis.get(watchkeys);
            int valint = Integer.valueOf(val);
            String userinfo = UUID.randomUUID().toString();
            if (valint < 10) {
                Transaction tx = jedis.multi();// 开启事务
                tx.incr(watchkeys);
                //有一个乐观锁机制
                List<Object> list = tx.exec();// 提交事务，如果此时watchkeys被改动了，则返回null
                if (list != null) {
                    System.out.println("用户：" + userinfo + "抢购成功，当前抢购成功人数:"
                            + (valint + 1));
                /* 抢购成功业务逻辑 */
                    jedis.sadd("setsucc", userinfo);
                } else {
                    System.out.println("用户：" + userinfo + "抢购失败");
                /* 抢购失败业务逻辑 */
                    jedis.sadd("setfail", userinfo);
                }


            } else {
                System.out.println("用户：" + userinfo + "抢购失败");
                jedis.sadd("setfail", userinfo);
                // Thread.sleep(500);
                return;

            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }
}
