package com.kito.deepstudy.io.pattern;/**
 * Created by hasee on 2017/7/19.
 */

/**
 * @author zhaoyi
 * @createTime 2017-07-2017/7/19-20:13
 */
public class Voice {
    private int voice=10;

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }

    public void say(){
        System.out.println("voice = " + voice);
    }
}
