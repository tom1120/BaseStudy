package com.kito.zhaoyi;

import java.math.BigInteger;

import org.junit.Test;

/**
 * 2015年12月20日
 * 
 * @author zhaoyi TODO
 */
public class Testfor {
	/*
	 * 打印九九乘法表 
	 * 1*1=1 
	 * 1*2=2 2*2=4 
	 * 1*3=3 2*3=6 3*3=9
	 * ........
	 */

	public void getChengFa() {
		for (int j = 1; j <= 9; j++) {//行数
			for (int i = 1; i <= j; i++) {//小于等于行数的数
				System.out.print(i + "*" + j + "=" + i * j + "\t");
			}
			System.out.println();
		}

	}
	
	public void getchengfa_while() {
		int j = 1;// 初始化
		while (j <= 9) {
			int i=1;//循环体内初始化
			while (i <= j) {// 循环终止条件

				System.out.print(i + "*" + j + "=" + i * j + "\t");

				i++;

			}

			System.out.println();
			j++;

		}

	}

	/**
	 * 
	 * 2015年12月20日 zhaoyi TODO case穿透
	 */
	public void getCase() {
		int i = 2;
		switch (i) {
		case 1:
			System.out.println("值为1");
			break;
		case 2:
			System.out.println("值为2");
			break;
		case 3:
			System.out.println("值为3");
			break;
		default:
			System.out.println("值为4");
		}

	}
	/**
	 * 
	 * 2015年12月20日
	 * zhaoyi
	 * TODO
	 * 计算1到100之和
	 */
	public void getJiSuan() {
		int sum=0;
		for (int i = 1; i <=100; i++) {
			sum+=i;
		}
		System.out.println("1到100的和："+sum);
	}
	/**
	 * 
	 * @param n
	 * @return 1到n之和
	 */
	public long getJiSuanJieCheng(int n) {
		long cj=0;
		while(n!=0){
			cj+=n;
			n--;
		}
		return cj;
	}
	/**
	 * ∑1到∑100的和
	 */
//	@Test
	public void getJiSuanOneToHundredOfSum(){
		long sum=0;
		for(int i=1;i<=100;i++){
			sum+=getJiSuanJieCheng(i);
		}
		System.out.println("∑1到∑100的:"+sum);

	}
	
	/**
	 * 
	 * @param n
	 * @return 求n!
	 */
	public BigInteger getJiSuanJieCheng1(int n) {
		BigInteger cj=new BigInteger("1");
		
		while(n!=1){
			cj=cj.multiply(new BigInteger(Integer.valueOf(n).toString()));
			n--;
		}
		return cj;
	}
	/**
	 * for循环实现100内奇数与偶数的和
	 */
//	@Test
	public void getHundredOfSumOddEven(){
		int oddSum=0,evenSum=0;
		for(int i=1;i<=100;i++){
			if(i%2!=0){
				oddSum+=i;
			}else{
				evenSum+=i;
			}
		}
		System.out.println("1到100的奇数和："+oddSum);
		System.out.println("1到100的偶数和："+evenSum);
	}
	/**
	 * while循环实现100内奇数与偶数的和
	 */
//	@Test
	public void getHundredOfSumOddEven1(){
		int oddSum=0,evenSum=0,i=1;
		while(i<=100){
			if(i%2!=0){
				oddSum+=i;
			}else{
				evenSum+=i;
			}
			i++;
		}
		System.out.println("1到100的奇数和："+oddSum);
		System.out.println("1到100的偶数和："+evenSum);
	}
	/**
	 * 获取1到1000内被5整除的数，按3个每行打印
	 */
	@Test
	public void getThousandOfDividedByFive(){
		
		for (int i = 1; i <=1000; i++) {
			if(i%5==0){
				System.out.print(i+"\t");
			}
			if(i%15==0){
				System.out.println();
			}
		}
		
	}
	
	/**
	 * 
	 * 2015年12月20日
	 * zhaoyi
	 * TODO
	 * 计算1！+2！+...100!之和
	 */
//	@Test
	//只能是public
	public void getJisuan1() {
		BigInteger sum=new BigInteger("0");
		for (int i = 1; i <=100; i++) {
			sum=sum.add(getJiSuanJieCheng1(i));
		}
		System.out.println(sum);
		
	}
	
	
	
	
	/**
	 * 2015年12月20日 zhaoyi TODO
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

}
