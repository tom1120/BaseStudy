package com.kito.thread.base;/**
 * Created by hasee on 2016/11/22.
 */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author zhaoyi
 * @createTime 2016-11-2016/11/22-22:28
 */
public class CallableClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程
        ExecutorService service= Executors.newFixedThreadPool(1);
        CallableInterface callableInterface=new CallableInterface();
        //获取值
        Future<Integer> future=service.submit(callableInterface);
        int num=future.get();
        System.out.println("num = [" + num + "]");
        //停止服务
        service.shutdown();

    }
}
