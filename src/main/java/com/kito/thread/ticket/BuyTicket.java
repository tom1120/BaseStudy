package com.kito.thread.ticket;/**
 * Created by hasee on 2016/11/19.
 */

/**
 * 线程安全
 * @author zhaoyi
 * @createTime 2016-11-2016/11/19-22:33
 */
public class BuyTicket implements Runnable {
    //ticket number
    private int num=20;

    private boolean flag=true;
    //buy ticket
    @Override
    public void run() {
        while (flag){
            test3();
        }
    }
    //线程安全
    public synchronized void test2(){
        if(num<=0){
            this.flag=false;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"抢到了" + num--);
    }
    //线程不安全
    public void test1(){
        if(num<=0){
            this.flag=false;
            return;
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"抢到了" + num--);
    }
    //线程安全
    public void test3(){
        synchronized(this){
            if(num<=0){
                this.flag=false;
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"抢到了" + num--);
        }
    }

}
