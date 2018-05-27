package com.kito.zhaoyi.collection.list;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * set不能重复的的无序集合，类似数据描述里面的集合
 * 底层采用hashmap实现，键不能重复
 * 2016年6月9日
 * @author zhaoyi
 * TODO
 */
public class MyHashSet extends AbstractSet implements Set{
	final static Object value=new Object();
	private Map map;
	private int size;
	public MyHashSet(){
		super();
		map=new HashMap();
	}
	
	public boolean add(Object key){
	  return map.put(key, value)==null;
	}
	
	public int size(){
		return map.size();
	}
	
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return map.keySet().iterator();
	}
	
	
	
	/**
	 * 2016年6月9日
	 * zhaoyi
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashSet mhs=new MyHashSet();
		mhs.add("abc");
		mhs.add("abcd");
		
		System.out.println(mhs.size());
		
		Iterator iterator = mhs.iterator();
		while(iterator.hasNext()){
			String  s=(String) iterator.next();
			System.out.println(s);
		}
		
		for(Iterator iterator1=mhs.iterator();iterator1.hasNext();){
			String  s=(String) iterator1.next();
			System.out.println(s);
		}
		
		
		
	}




}
