package com.kito.zhaoyi.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 2016年4月6日
 * @author zhaoyi
 * TODO
 */
public class TestDataFormat {

	/**
	 * 2016年4月6日
	 * zhaoyi
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS");
		Date d=new Date();
		System.out.println(df.format(d));
		
		String str="1998,11,02";
		DateFormat df1=new SimpleDateFormat("yyyy,MM,dd");
		try {
			
			System.out.println(df1.parse(str));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
