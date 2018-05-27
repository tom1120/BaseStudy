package designPattern.proxyPattern.dynamicProxy.improvethree;

import java.lang.reflect.InvocationHandler;

public class SubjectDynamicProxy extends DynamicProxy {
	public static <T> T newProxyInstance(ISubject subject){
		//获取ClassLoader
		ClassLoader loader=subject.getClass().getClassLoader();
		//获得接口数组
		Class<?>[] interfaces=subject.getClass().getInterfaces();
		//获得handler
		InvocationHandler handler=new MyInvocationHandler(subject);
		return newProxyInstance(loader,interfaces,handler);
		
	}
}
