package com.kito.deepstudy.fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * 2016年6月13日
 * @author zhaoyi
 * TODO
 */
public class FanXing{
	
	public static void main(String[] args) {
		//不使用泛型时存在问题
		List list=new ArrayList();
		list.add("sssss");
		list.add(123);
		if(list.get(0) instanceof String){
			String s=(String) list.get(0);
			System.out.println(s);
		}
		if(list.get(1) instanceof Integer){
			Integer i=(Integer) list.get(1);
			System.out.println(i);
		}
		//使用泛型后类型安全、省心
		List<String> list2=new ArrayList<String>();
		list2.add("aaa");
		list2.add("bbb");
		list2.add("ccc");
		list2.add("ddd");
		String s2=list2.get(0);
		System.out.println(s2);
		
	}
	
}
