package com.kito.zhaoyi;

/**
 * 2016年1月1日
 * @author zhaoyi
 * TODO
 */
public class TestRecerence {
	/**
	 * 递归测试
	 * 2016年1月1日
	 * zhaoyi
	 * TODO
	 */
	public static long recerence(int n){
		if(n==1){
			return 1;
		}
		return n*recerence(n-1);
		
	}
	
	/**
	 * 2016年1月1日
	 * zhaoyi
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a=recerence(10);
		System.out.println(a);
	}

}
