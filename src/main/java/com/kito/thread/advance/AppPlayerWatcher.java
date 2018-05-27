package com.kito.thread.advance;/**
 * Created by hasee on 2017/7/30.
 */

/**
 * @author zhaoyi
 * @createTime 2017-07-2017/7/30-20:18
 */
public class AppPlayerWatcher {

    public static void main(String[] args) {
        Movie movie=new Movie();
        Player player=new Player(movie);
        Watcher watcher=new Watcher(movie);
        Thread t1=new Thread(player);
        Thread t2=new Thread(watcher);

        t1.start();
        t2.start();


    }
}
