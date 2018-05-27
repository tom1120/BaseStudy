package designPattern.proxyPattern.dynamicProxy.improvethree;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
	
	//被代理对象
	private Object target=null;
	//初始化被代理对象
	public MyInvocationHandler(Object _target){
		this.target=_target;
		
	}
	
	//代理方法
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		//如果调用特定方法发送通知
//		if(method.getName().equalsIgnoreCase("doSomeThing")){
//			IAdvice advice=new Advice();
//			advice.exec();
//		}
		Object result=method.invoke(this.target, args);
		return result;
	}

}
