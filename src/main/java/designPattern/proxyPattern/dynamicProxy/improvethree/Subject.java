package designPattern.proxyPattern.dynamicProxy.improvethree;
/**
 * 
 * @author zhaoyi
 * @date 2016年3月23日
 * @name Subject
 * @TODO 真实角色
 */
public class Subject implements ISubject{

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("做事情啦！");
	}
	
}
