package com.kito.zhaoyi;

public class BaseDataType {
	/**
	 * 8大基本数据类型的测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		// 整数默认是int类型
		byte a = 1;// 1个字节8bit -128~127
		short b = 100;// 2个字节16bit -32768~32767
		int c = 1;// 4个字节32bit -2147483648~2147483647
		long d = 200;// 8个字节64bit -9223372036854775808~9223372036854775807
		// 浮点数默认是double，所以需要强制转型
		float e = (float) 3.14e2;//4个字节 -3.403e38~+3.403e38
		float e1=3.14e2f;//加上f改变默认数据为float
		double f = 1.79e3;//8个字节-1.798e308~1.798e308
		
		
		char g = 'a';
		boolean h = true;
		
		a=(byte)(Math.pow(2, 7)-1);
		b=(short) (Math.pow(2,15)-1);
		c=(int) (Math.pow(2, 31)-1);
		d=(long)(Math.pow(2, 63)-1);
		
		int c1=0x10;
		int c2=010;
		int c3=10;
		
		System.out.println(c1+"\t"+c2+"\t"+c3);
		
		System.out.println(Integer.toBinaryString(c1));
		System.out.println(Integer.toHexString(c2));
		System.out.println(Integer.toOctalString(c3));
		*/
		
		/**
		 * 基本数据类型转换测试
		 */
		//默认是int类型，含隐式转换
		byte a=127;
		int b=a;
		byte c=(byte) b;
		
		int d=11;
		short e=(short) d;
		//容量小类型可隐式转换为容量大类型，容量大类型转换为容量小类型可能回丢失精度，需要强制转换
		System.out.println(c);
		
		//布尔类型转换
		char t=1;
		
		
		/***
		 * 类型自动提升,容量小的可以自动转换为容量大的数据类型[隐式转换]，除了赋值不超过其容量范围
		 */
		
		
		
		
	}

}
