package com.kito.thread.task;/**
 * Created by hasee on 2017/7/30.
 */

import java.util.Date;
import java.util.Timer;

/**
 * @author zhaoyi
 * @createTime 2017-07-2017/7/30-20:49
 */
public class AppTime {
    public static void main(String[] args) {
        Timer timer=new Timer();
        timer.schedule(new TimeTaskExample(),new Date(),10000L);
    }
}
