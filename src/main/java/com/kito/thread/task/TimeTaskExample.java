package com.kito.thread.task;/**
 * Created by hasee on 2017/7/30.
 */

import java.util.TimerTask;

/**
 * @author zhaoyi
 * @createTime 2017-07-2017/7/30-20:48
 */
public class TimeTaskExample extends TimerTask {
    @Override
    public void run() {
        System.out.println("任务调度执行了");
    }
}
