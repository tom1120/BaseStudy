package cn.qlong.basic.statics;

/**
 * Created by zhaoyipc on 2021-04-16.
 */
public class HelloB extends HelloA {
    private int j=12;

    public HelloB() {
        System.out.println("HelloB");
    }

    {
        System.out.println("I'm B class");
    }

    static {
        System.out.println("Static B");
    }
}
