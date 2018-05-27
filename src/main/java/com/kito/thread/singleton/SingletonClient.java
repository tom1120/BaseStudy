package com.kito.thread.singleton;/**
 * Created by hasee on 2016/12/20.
 */

/**
 * @author zhaoyi
 * @createTime 2016-12-2016/12/20-21:12
 */
public class SingletonClient {
    //一个main主线程
    public static void main(String[] args) {
        Jvm jvm1=Jvm.getInstance(200);
        System.out.println("jvm1 = " + jvm1.hashCode());
        Jvm jvm2=Jvm.getInstance(200);
        System.out.println("jvm2 = " + jvm2.hashCode());

    }
}
