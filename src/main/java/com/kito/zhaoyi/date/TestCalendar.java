package com.kito.zhaoyi.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 2016年4月6日
 * @author zhaoyi
 * TODO
 */
public class TestCalendar {

	/**
	 * 2016年4月6日
	 * zhaoyi
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		Calendar c=Calendar.getInstance();
		System.out.println(c.getTime());*/
		Calendar c1=new GregorianCalendar();
		c1.set(2001, 1, 10);
		Date d=c1.getTime();
		Long l=c1.getTimeInMillis();
		System.out.println(d+"######"+l);
		
		
		Calendar c2=new GregorianCalendar();
		c2.set(Calendar.YEAR, 2011);
		c2.set(Calendar.MONTH, 0);
		c2.set(Calendar.DAY_OF_MONTH, 1);
		System.out.println(c2.getTime());
		c2.add(Calendar.YEAR, -10);
		System.out.println(c2.getTime());
	}

}
