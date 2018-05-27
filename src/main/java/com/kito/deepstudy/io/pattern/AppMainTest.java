package com.kito.deepstudy.io.pattern;/**
 * Created by hasee on 2017/7/19.
 */

/**
 * @author zhaoyi
 * @createTime 2017-07-2017/7/19-20:15
 */
public class AppMainTest {
    public static void main(String[] args) {
        Voice voice=new Voice();
        voice.say();
        KuoYingQi kuoYingQi=new KuoYingQi(voice);
        kuoYingQi.say();
    }
}
