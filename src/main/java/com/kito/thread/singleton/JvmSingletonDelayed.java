package com.kito.thread.singleton;/**
 * Created by hasee on 2016/12/20.
 */

/**
 * 饿汉式的单例
 * 静态初始化类变量
 *
 * @author zhaoyi
 * @createTime 2016-12-2016/12/20-22:15
 */
public class JvmSingletonDelayed {

    private JvmSingletonDelayed(){}

    public static JvmSingletonDelayed getInstance(){
        return InnerClass.jvmSingleton;
    }
    //延迟加载
    private static class InnerClass {
        private static JvmSingletonDelayed jvmSingleton = new JvmSingletonDelayed();
    }
}
