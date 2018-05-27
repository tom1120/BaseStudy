package com.kito.zhaoyi.oop.testInterface;

/**
 * 2016年3月13日
 * @author zhaoyi
 * TODO
 */
public interface TestInterfaceExtends {
	public abstract int add(int a,int b);

}
interface Test1{
	int add(int a,int b,int c);
}
interface Test2 extends TestInterfaceExtends,Test1{
	long muti(int a,int b);
}
