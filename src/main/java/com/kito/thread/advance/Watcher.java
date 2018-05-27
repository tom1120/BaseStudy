package com.kito.thread.advance;/**
 * Created by hasee on 2017/7/30.
 */

/**
 * @author zhaoyi
 * @createTime 2017-07-2017/7/30-20:13
 */
public class Watcher implements Runnable{
    private Movie m;

    public Watcher(Movie m) {
        this.m = m;
    }

    public Watcher() {
    }

    public void setM(Movie m) {
        this.m = m;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            m.watch();
        }
    }
}
