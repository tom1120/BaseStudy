package com.kito.thread.base;/**
 * Created by hasee on 2016/11/19.
 */

/**
 * @author zhaoyi
 * @createTime 2016-11-2016/11/19-21:03
 */
public class ExtendsThreads extends Thread{
    @Override
    public void run(){
        System.out.println("子线程被调用了！");
        for (int i = 0; i <20 ; i++) {
            System.out.println("子线程i#######:"+i);
        }
    }
}
