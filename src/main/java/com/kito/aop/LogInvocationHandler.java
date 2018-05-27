package com.kito.aop;/**
 * Created by hasee on 2017/5/15.
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhaoyi
 * @createTime 2017-05-2017/5/15-23:47
 */
public class LogInvocationHandler implements InvocationHandler {
    private Object target;//目标对象

    public LogInvocationHandler(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //执行原有逻辑
        Object rev=method.invoke(target,args);
        //执行织入的日志，你可以控制哪些方法执行切入逻辑
        if(method.getName().equals("doSomeThing2")){
            System.out.println("记录日志");
        }
        return rev;
    }
}
