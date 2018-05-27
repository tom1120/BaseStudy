package com.kito.zhaoyi.stringBuffer;

/**
 * 2016年3月13日
 * @author zhaoyi
 * TODO
 */
public class Test02 {

	/**
	 * 2016年3月13日
	 * zhaoyi
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder("abcdefg");
		System.out.println(sb.length());
		System.out.println(sb.delete(3, 5));
		sb.reverse();
		System.out.println(sb);
	}

}
