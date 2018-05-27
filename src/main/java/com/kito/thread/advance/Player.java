package com.kito.thread.advance;/**
 * Created by hasee on 2017/7/30.
 */

/**
 * 生产者
 * @author zhaoyi
 * @createTime 2017-07-2017/7/30-20:13
 */
public class Player implements Runnable{
    private Movie  m;

    public Player(Movie m) {
        this.m = m;
    }

    public Player() {
    }

    public void setM(Movie m) {
        this.m = m;
    }

    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            String movieName="生产者"+i;
            m.make(movieName);
            System.out.println("生产了movieName="+movieName);
        }
    }
}
