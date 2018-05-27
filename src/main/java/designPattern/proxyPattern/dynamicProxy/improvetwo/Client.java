package designPattern.proxyPattern.dynamicProxy.improvetwo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 创建真实角色对象
		ISubject subject = new Subject();
		// 创建handler处理真实角色对象
		InvocationHandler handler = new MyInvocationHandler(subject);
		// 动态代理处理
		ISubject proxy = DynamicProxy.newProxyInstance(subject.getClass()
				.getClassLoader(), subject.getClass().getInterfaces(), handler);
		//代理执行真实角色行为
		proxy.doSomething();
		

	}
}
