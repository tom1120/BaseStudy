package com.kito.thread.ticket;/**
 * Created by hasee on 2016/11/19.
 */

/**
 * @author zhaoyi
 * @createTime 2016-11-2016/11/19-22:41
 */
public class BuyTicketClient {
    public static void main(String[] args) {
        //真实角色
        BuyTicket buyTicket=new BuyTicket();
        //代理角色
        Thread t1=new Thread(buyTicket,"学生");
//        t1.setPriority(Thread.MIN_PRIORITY);
        Thread t2=new Thread(buyTicket,"农民工");
//        t2.setPriority(Thread.NORM_PRIORITY);
        Thread t3=new Thread(buyTicket,"白领");
        Thread t4=new Thread(buyTicket,"黄牛1");
        Thread t5=new Thread(buyTicket,"黄牛2");
        Thread t6=new Thread(buyTicket,"黄牛3");

//        t10.setPriority(Thread.MAX_PRIORITY);
        //启动线程

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();



    }
}
