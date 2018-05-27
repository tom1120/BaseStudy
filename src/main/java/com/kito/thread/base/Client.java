package com.kito.thread.base;/**
 * Created by hasee on 2016/11/19.
 */

/**
 * 场景类
 * @author zhaoyi
 * @createTime 2016-11-2016/11/19-21:11
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("main线程被调用");
        ExtendsThreads extendsThreads=new ExtendsThreads();
        extendsThreads.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程i:"+i);
        }
    }
}
