/**
* @Title: Test.java 
* @Package com.kito.zhaoyi 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author zhaoyi   
* @date 2015��8��22�� ����2:34:29 
* @version V1.0   
 */
package com.kito.zhaoyi;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test {
	
	public static void main(String[] args){
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat df=new SimpleDateFormat("HH:mm:ss");
		System.out.println("时间："+df.format(calendar.getTime()));
		
		calendar.set(Calendar.HOUR_OF_DAY, 9);
		calendar.set(Calendar.MINUTE, 30);
		calendar.set(Calendar.SECOND, 10);
		String t1=df.format(calendar.getTime());
		String c=df.format(System.currentTimeMillis());
		
		System.out.println("时间："+t1);
		
		System.out.println("时间："+c.compareTo(t1));
		
		int i=0;
		int j=++i;
		System.out.println(j);
		System.out.println(i);
		
		
		System.out.println(new String("123").equals(new String("123")));
		
	}
}
