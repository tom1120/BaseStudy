package com.kito.zhaoyi.oop.inherit;

/**
 * 2016年3月13日
 * @author zhaoyi
 * TODO
 */
public class FartherClass {
	int i;
	public int add(int a,int b){
		return a+b;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public static void main(String[] args) {
		SonClass s=new SonClass();
		System.out.println(s.add(1,2));
		System.out.println(s.multiplication(2, 4));
		System.out.println(s.toString());
		s.setNum(100);
		
		FartherClass f=new FartherClass();
		
		System.out.println(f.toString());
		System.out.println(f.i);

	}
	
}
class SonClass extends FartherClass{
	public long multiplication(int a,int b){
		return a*b;
	}
	
	public void setNum(int i){
		super.i=i;
		System.out.println(super.i);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "子类执行";
	}
	
	
	
}