package com.kito.thread.singleton;/**
 * Created by hasee on 2016/12/20.
 */

/**
 * 多线程会出现非单例的问题，出现线程不安全
 * @author zhaoyi
 * @createTime 2016-12-2016/12/20-21:23
 */
public class MoreThreadRunTest {
    public static void main(String[] args) {
        MoreThreadClient moreThreadClient=new MoreThreadClient();
        Thread t1=new Thread(moreThreadClient,"线程1");
        Thread t2=new Thread(moreThreadClient,"线程2");

        t1.start();
        t2.start();
        /**
         * 线程1jvm.hashCode() = 522603986
         线程2jvm.hashCode() = 439462096
         */
    }
}
