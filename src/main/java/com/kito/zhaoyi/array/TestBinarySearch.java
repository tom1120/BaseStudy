package com.kito.zhaoyi.array;

import java.util.Arrays;

/**
 * 2016年4月5日
 * @author zhaoyi
 * TODO
 */
public class TestBinarySearch {
	
	

	/**
	 * 2016年4月5日
	 * zhaoyi
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(args[0]);
		int arr[]={123,12,5,6,89,75,63,34,200,700,500,20};
		int searchNum=89;
		int searchCount=0;
		System.out.printf("普通循环查找%d的次数是%d",searchNum,genetalLoop(arr,searchNum));
		System.out.println();
		System.out.printf("二分法查找%d的次数是%d",searchNum,binarySearch(arr, searchNum));
		
	}
	
	//普通查找
	static int genetalLoop(int[] arr,int searchNum){
		int searchCount=0;
		for(int i:arr){
			searchCount++;
			if(i==searchNum)
				break;
		}
		return searchCount;
	}
	
	//二分法查找
	static int binarySearch(int[] arr,int searchNum){
		int searchCount=0;
		Arrays.sort(arr);//先排序
		System.out.println(Arrays.toString(arr));
		int iIndex=0;//二分时的索引
		int iStart=0;
		int iEnd=arr.length-1;
		//二分法查找
		for(int i=0;i<arr.length/2;i++){
			searchCount++;
			iIndex=(iStart+iEnd)/2;
			if(arr[iIndex]<searchNum){
				iStart=iIndex;
			}else if(arr[iIndex]>searchNum){
				iEnd=iIndex;
			}else{
				break;
			}
			
			
		}
		return searchCount;
		
	}

}
