package com.kito.thread.race;/**
 * Created by hasee on 2016/11/22.
 */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author zhaoyi
 * @createTime 2016-11-2016/11/22-22:53
 */
public class RaceClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Race tortoise=new Race("乌龟",500);
        Race Rabbit=new Race("兔子",200);
        Future<Integer> futuretortoise=executorService.submit(tortoise);
        Future<Integer> futureRabbit=executorService.submit(Rabbit);

        Thread.sleep(2000);
        tortoise.setFlag(false);
        Rabbit.setFlag(false);

        int rabbitStep=futureRabbit.get();
        int tortoiseStep=futuretortoise.get();
        System.out.println("rabbitStep = [" + rabbitStep + "]");
        System.out.println("tortoiseStep = [" + tortoiseStep + "]");

        executorService.shutdown();

    }
}
