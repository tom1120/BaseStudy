package com.kito.zhaoyi.box;

/**
 * 2016年4月6日
 * @author zhaoyi
 * TODO
 */
public class TestBox {

	/**
	 * 2016年4月6日
	 * zhaoyi
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a=1000;//Integer a=new Integer(1000)
		
		int b=new Integer(1000);//int b=new Integer(1000).intValue();
		
		Integer d=1234;
		Integer d2=1234;
		System.out.println(d==d2);
		System.out.println(d.equals(d2));
		
		System.out.println("#######");
		Integer d3=123;//[-128,127]之间的数，任然当做基本数据类型处理
		Integer d4=123;
		System.out.println(d3==d4);
		System.out.println(d3.equals(d4));
		
	}

}
