package com.kito.thread.race;/**
 * Created by hasee on 2016/11/22.
 */

import java.util.concurrent.Callable;

/**
 * @author zhaoyi
 * @createTime 2016-11-2016/11/22-22:40
 */
public class Race implements Callable<Integer>{
    //参加比赛的人员名称
    private String name;

    //跑步开始与结束标志
    private boolean flag=true;

    //延时时间
    private long time;

    //步数
    private int step=0;


    //开始跑与结束跑后返回跑的步数
    @Override
    public Integer call() throws Exception {
        while (flag){
            Thread.sleep(time);
            step++;
        }
        return step;
    }

    public Race(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public Race() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
