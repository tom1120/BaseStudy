package com.kito.zhaoyi.string;

/**
 * 2016年3月13日
 * @author zhaoyi
 * TODO
 */
public class TestString {
	public static void main(String[] args) {
		String a=new String("abcd");
		String b=new String("abcd");
		System.out.println(a.equals(b));
		System.out.println(a==b);
		
		String x="123";
		String y="123";
		System.out.println(x.equals(y));
		System.out.println(x==y);
		
		System.out.println(x.indexOf("2"));
		System.out.println(x.charAt(0));
		System.out.println(x.substring(1, 2));
		System.out.println(x.replace("1", "a"));
		
		String s="abc,dfd,123,r3r";
		String[] ss=s.split(",");
		for(String abc:ss){
			System.out.println(abc);
		}
		
		String m="   avv dfsd  ";
		System.out.println(m.trim().length());
		
		System.out.println("abc".equalsIgnoreCase("Abc"));
		
		System.out.println("abc".indexOf("b"));
		System.out.println("abc".lastIndexOf("b"));
		
		System.out.println("abc".startsWith("ab"));
		System.out.println("abc".endsWith("bc"));
		
		System.out.println("abc".toUpperCase());
		System.out.println("ABC".toLowerCase());
		
		
		
	}
}
