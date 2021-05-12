package cn.qlong.basic.statics;

/**
 * Created by zhaoyipc on 2021-04-16.
 */
public class HelloA {
    private int i=10;

    public HelloA() {
        System.out.println("HelloA");
    }

    {
        System.out.println("I'm A class");
    }

    static {
        System.out.println("Static A");
    }



}
