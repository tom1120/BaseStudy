package com.kito.zhaoyi.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 2016年4月6日
 * @author zhaoyi
 * TODO
 */
public class TestPrintCalendar {

	/**
	 * 2016年4月6日
	 * zhaoyi
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入日期（输入格式：2011-1-10）：");
		Scanner scanner=new Scanner(System.in);
		String str=scanner.nextLine();
		
		
//		String str="2016-4-7";
//		Calendar c=new GregorianCalendar();
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date=df.parse(str);
			Calendar c=new GregorianCalendar();
			c.setTime(date);
			
			c.set(Calendar.DATE, 1);//设置从1号开始打印
//			System.out.println(c.get(Calendar.DAY_OF_WEEK));//返回周几数字表示
//			System.out.println(c.getActualMaximum(Calendar.DATE));//返回日期所在月的最大日期
			
			int maxDate=c.getActualMaximum(Calendar.DATE);
			int weekNum=c.get(Calendar.DAY_OF_WEEK);
			
			System.out.print("日\t一\t二\t三\t四\t五\t六");			
			System.out.println();
			//1号之前打印需要打印多少空格
			for(int i=0;i<weekNum-1;i++){
				System.out.print("\t");
			}
			
			
			

			for(int i=1;i<=maxDate;i++){
				System.out.print(i+"\t");
				//星期六时换行
				if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){
					System.out.println();
				}

				c.add(Calendar.DATE, 1);

			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
