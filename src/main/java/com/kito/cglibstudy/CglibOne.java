package com.kito.cglibstudy;/**
 * Created by hasee on 2017/5/17.
 */

import com.kito.aop.Business;
import com.kito.aop.IBusiness2;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *
 * spring aop总结:
 　　如果加入容器的目标对象有实现接口,用JDK代理
 　　如果目标对象没有实现接口,用Cglib代理 　　
 　　如果目标对象实现了接口，且强制使用cglib代理，则会使用cglib代理

 *
 * 类+切入逻辑织入器织入并生成子类
 * @author zhaoyi
 * @createTime 2017-05-2017/5/17-22:03
 */
public class CglibOne {
    public static void main(String[] args) {
        byteCodeGe();
    }

    public static void byteCodeGe() {
        //创建一个织入器
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(Business.class);
        //设置需要织入的逻辑
        enhancer.setCallback(new LogIntercept());
        //使用织入器创建子类
        IBusiness2 newBusiness = (IBusiness2) enhancer.create();
        newBusiness.doSomeThing2();
    }

    /**
     * 记录日志
     */
    public static class LogIntercept implements MethodInterceptor {
        @Override
        public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            //执行原有逻辑，注意这里是invokeSuper
            Object rev = proxy.invokeSuper(target, args);
            //执行织入的日志
            if (method.getName().equals("doSomeThing2")) {
                System.out.println("记录日志");
            }
            return rev;
        }
    }

}

