package com.kito.zhaoyi.array;

import java.util.Iterator;

/**
 * 2016年3月13日
 * @author zhaoyi
 * TODO
 */
public class TestArray {

	/**
	 * 2016年3月13日
	 * zhaoyi
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 1)数组是相同类型的有序集合
		 * 2）数组元素相当于类的成员变量
		 * 3）数组长度是不可变的
		 */
		int[] a=new int[3];
		a[0]=12;
		a[1]=13;
		a[2]=14;
		for(int i:a){
			System.out.println(i);
		}
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		//静态初始化
		int[] t={1,2,3,4};
		
		//数组copy
		int[] a1={1,2,3};
		int[] a2=new int[8];
		System.arraycopy(a1, 0, a2, 1, 2);
		System.out.println(a2[1]);
		
	}

}
