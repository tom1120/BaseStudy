package com.kito.thread.advance;/**
 * Created by hasee on 2017/7/30.
 */

/**
 * 资源
 * 生产者与消费者，采取信号灯法
 * @author zhaoyi
 * @createTime 2017-07-2017/7/30-20:03
 */
public class Movie {
    private String movieName;
    //flag信号为true为消费等待,生产开始，生产完成通知消费；false为生产等待,消费开始，消费完成后通知生产。默认从开始生产
    private boolean flag=true;

    /**
     * 资源生产
     * @param movieName
     */
    public synchronized void make(String movieName){
        if(!flag){
            //等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //开始生产
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.movieName=movieName;
        //通知消费者线程
        this.notifyAll();
        //停止生产
        this.flag=false;


    }

    /**
     * 资源消费
     */
    public synchronized void watch(){
        //生产时消费等待
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        //消费
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("现在看的是movieName = " + movieName);
        //消费完毕通知生产
        this.notifyAll();
        //停止消费
        this.flag=true;


    }

}
