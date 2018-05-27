package com.kito.zhaoyi.oop.servlet;

/**
 * 2016年1月1日
 * @author zhaoyi
 * TODO
 */
public class MyServlet extends HttpServlet{
	
	public void doGet(){
		System.out.println("MyServlet.doGet()");
	}

	/**
	 * 2016年1月1日
	 * zhaoyi
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HttpServlet hs=new MyServlet();
		hs.service();
	}

}
