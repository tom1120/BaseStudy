package com.kito.thread.singleton;/**
 * Created by hasee on 2016/12/20.
 */

/**
 * 懒汉式单例，使用时才创建，
 * 保证创建一次即可
 * 私有化构造方法
 * @author zhaoyi
 * @createTime 2016-12-2016/12/20-21:06
 */
public class Jvm {

    private static Jvm jvm=null;
    private Jvm(){
    }

    public static  Jvm getInstance(long time){

        synchronized(Jvm.class){
            createInstance(time);
        }


        return jvm;

    }
    public static synchronized Jvm getInstance1(long time){
        createInstance(time);
        return jvm;

    }

    public static  Jvm getInstance2(long time){
        if(jvm==null){//提高效率
            synchronized(Jvm.class){
                createInstance(time);
            }
        }



        return jvm;

    }



    /**
     * 效率不高
     * @param time
     */
    private static void createInstance(long time) {
        if(jvm==null){
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            jvm=new Jvm();
        }
    }

}
