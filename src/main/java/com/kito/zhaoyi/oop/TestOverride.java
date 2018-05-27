package com.kito.zhaoyi.oop;

/**
 * 2016年3月13日
 * @author zhaoyi
 * TODO
 */
public class TestOverride {
	public int add(int a,int b){
		return a+b;
	}
	public static void main(String[] args) {
		MyMath math=new MyMath();
		math.add(1, 2);
		math.add(1.2, 2);
		TestOverride t=new TestOverride();
		t.add(1,2);
	}
}
class MyMath{
	public int add(int a,int b){
		return a+b;
	}
	public double add(double a,int b){
		return a+b;
	}
	public double add(int a,double b){
		return a+b;
	}
}