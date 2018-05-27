package com.kito.deepstudy.io.pattern;/**
 * Created by hasee on 2017/7/19.
 */

/**
 * 类与类之间有以下关系
 * 1、依赖：形参与局部变量
 * 2、关联：属性
 *       聚合：属性整体与部分不一致生命周期 人与手
 *       组合：属性整体与部分一致生命周期 人与大脑
 * 3、继承：父子类
 * 4、实现：接口与实现类
 * @author zhaoyi
 * @createTime 2017-07-2017/7/19-20:14
 */
public class KuoYingQi {
    private Voice voice;

    public KuoYingQi() {
    }

    public KuoYingQi(Voice voice) {
        this.voice = voice;
    }

    public void say(){
        System.out.println("voice.getVoice()*100 = " + voice.getVoice()*100);
    }

}
