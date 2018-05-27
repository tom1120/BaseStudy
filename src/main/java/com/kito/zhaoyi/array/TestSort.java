package com.kito.zhaoyi.array;

import java.util.Arrays;

/**
 * 2016年4月5日
 * @author zhaoyi
 * TODO
 */
public class TestSort {
	/**
	 * 冒泡排序
	 * 2016年4月5日
	 * zhaoyi
	 * TODO
	 * @param values
	 */
	public static void sort(int[] values){
		int temp;
		for(int j=0;j<values.length;j++){
			for(int i=0;i<values.length-1-j;i++){
				if(values[i]>values[i+1]){
					temp=values[i+1];
					values[i+1]=values[i];
					values[i]=temp;
				}
			}
		}

		
	}

	
	/**
	 * 2016年4月5日
	 * zhaoyi
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={99,2,4,22,11,1,100,5,9};
/*		System.out.println(a);//[I@3fbefab0
		System.out.println(Arrays.toString(a));//[99, 2, 4, 22, 11, 1, 100, 5, 9]
		Arrays.sort(a);//使用二分法排序
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.binarySearch(a, 2));//非负数表示返回元素的索引
*/		
		sort(a);
		System.out.println(Arrays.toString(a));
	}

}
