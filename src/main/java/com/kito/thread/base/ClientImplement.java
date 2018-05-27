package com.kito.thread.base;/**
 * Created by hasee on 2016/11/19.
 */

/**
 * @author zhaoyi
 * @createTime 2016-11-2016/11/19-21:22
 */
public class ClientImplement {
    public static void main(String[] args) {
        ImplementRunnable implementRunnable=new ImplementRunnable();
        //代理模式
        Thread proxy=new Thread(implementRunnable);
        proxy.start();

        for (int i = 0; i <10 ; i++) {
            System.out.println("主线程i = " + i);
        }

    }
}
