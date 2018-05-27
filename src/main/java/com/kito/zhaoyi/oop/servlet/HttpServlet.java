package com.kito.zhaoyi.oop.servlet;

/**
 * 2016年1月1日
 * @author zhaoyi
 * TODO
 */
public class HttpServlet {
	public void service(){
		System.out.println("HttpServlet.service()");
		doGet();
	}
	public void doGet(){
		System.out.println("HttpServlet.doGet()");
	}
	
}
