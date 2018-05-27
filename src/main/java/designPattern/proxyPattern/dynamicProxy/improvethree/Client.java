package designPattern.proxyPattern.dynamicProxy.improvethree;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 创建真实角色对象
		ISubject subject = new Subject();
		// 动态代理处理
		ISubject proxy = SubjectDynamicProxy.newProxyInstance(subject);
		//代理执行真实角色行为
		proxy.doSomething();
		

	}
}
