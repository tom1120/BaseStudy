package com.kito.thread.singleton;/**
 * Created by hasee on 2016/12/20.
 */

/**
 * @author zhaoyi
 * @createTime 2016-12-2016/12/20-21:15
 */
public class MoreThreadClient implements Runnable{

    @Override
    public void run() {
        Jvm jvm=Jvm.getInstance2(200);
        System.out.println(Thread.currentThread().getName()+"jvm.hashCode() = " + jvm.hashCode());
    }

}
