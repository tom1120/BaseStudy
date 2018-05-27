package com.kito.zhaoyi.stringBuffer;

/**
 * 2016年3月13日
 * @author zhaoyi
 * TODO 测试可变字符序列，StringBuilder(线程安全，效率高)，StringBuffer(线程安全，效率低)
 */
public class Test01 {
	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder();//默认长度为16的数组
		StringBuilder sb1=new StringBuilder(32);
		StringBuilder sb2=new StringBuilder("abcd");//16+4
		sb2.append("efg").append("hij");//return this实现方法连接
		System.out.println(sb2);
		
		System.out.println("############");
		//数组扩容原理，两倍原有长度+2
		StringBuilder s=new StringBuilder("a");
		for(int i=0;i<1000;i++){
			s.append(i);
		}
		System.out.println(s);
		
		
	}
}
