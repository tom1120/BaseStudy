package com.kito.aop;/**
 * Created by hasee on 2017/5/15.
 */

/**
 * @author zhaoyi
 * @createTime 2017-05-2017/5/15-23:45
 */
public class Business implements IBusiness2,IBusiness {

    public void doSomeThing2() {
        System.out.println("执行业务逻辑2" );
    }


    public void doSomeThing() {
        System.out.println("执行业务逻辑" );
    }
}
