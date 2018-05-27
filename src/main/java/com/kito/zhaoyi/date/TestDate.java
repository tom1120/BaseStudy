package com.kito.zhaoyi.date;

import java.util.Date;

/**
 * 2016年4月6日
 * @author zhaoyi
 * TODO
 */
public class TestDate {

	/**
	 * 2016年4月6日
	 * zhaoyi
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date1=new Date();
		Date date=new Date(1000);
		System.out.println(date.toGMTString());
		System.out.println(System.currentTimeMillis());
		System.out.println(date1.getTime()<date.getTime());
	}

}
