package com.kito.zhaoyi.collection.list;

/**
 * 优化下map存储结构，存储结构改为数组+链表结构
 * 存储时存储地址%存储空间位置大小余数来存储索引所在位置
 * 如果索引所在位置已经存在元素了，就放到该元素的后面，二级存储结构为链表
 * 2016年6月5日
 * @author zhaoyi
 * TODO
 */
public class MyMap2 {
	private int length=999;
	private MyLinkedList[] ll=new MyLinkedList[length];
	private int size;
	
	public KeyValue get(Object key){
		MyLinkedList mll=ll[key.hashCode()%length];
		KeyValue kv=(KeyValue) mll.get(key).getObj();
		return kv;
	}
	
	public void add(Object key,Object value){
		MyLinkedList mll=new MyLinkedList();
		KeyValue kv=new KeyValue(key, value);
		mll.add(kv);
		ll[key.hashCode()%length]=mll;
	}
	
	

	/**
	 * 2016年6月5日
	 * zhaoyi
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyMap2 mm2=new MyMap2();
		mm2.add("赵义", new Wife("李嘉欣"));
		mm2.add("测试", new Wife("李佳琪"));
		Wife wf=(Wife) mm2.get("赵义").getValue();
		System.out.println(wf.getName());
		
	}

}
