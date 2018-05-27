package com.kito.zhaoyi.collection.list;

/**
 * 存储结构是数组结构，按顺序存储
 * 2016年6月3日
 * @author zhaoyi
 * TODO
 */
public class MyMap {
	private KeyValue[] keyvalue=new KeyValue[999];
	private int size;
	
	
	private void checkArray(int index) {
		if(index>=size||index<-1)
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	/**
	 * 添加key和value，键值对不能重复，重复就覆盖之前的value
	 * 2016年6月3日
	 * zhaoyi
	 * TODO
	 * @param key
	 * @param value
	 */
	public void add(Object key,Object value){
		KeyValue kv=new KeyValue(key, value);
		int j=0;
		for(int i=0;i<size;i++){
			if(keyvalue[i].getKey().equals(key)){
			   keyvalue[i].setValue(value);
			   j++;
			}
				
			
			
		}
		if(j==0){
			keyvalue[size++]=kv;
		}
		
	}
	
	public boolean containKey(Object key){
		for(int i=0;i<size;i++){
			if(keyvalue[i].getKey().equals(key)){
				return true;
				
			}
			
		}
		return false;
	}
	
	
	public boolean containValue(Object value){
		for(int i=0;i<size;i++){
			if(keyvalue[i].getValue().equals(value)){
				return true;
				
			}
			
		}
		return false;
	}
	public KeyValue get(int index){
		checkArray(index);
		return keyvalue[index];
		
	}
	
	public int size(){
		return size;
	}
	
	/**
	 * 
	 * 2016年6月3日
	 * zhaoyi
	 * TODO
	 * @param key
	 * @return 返回值
	 */
	public Object getValue(Object key){
		for(int i=0;i<size;i++){
			if(keyvalue[i].getKey().equals(key)){
				return keyvalue[i].getValue();
				
			}
		}
		return null;
		
	}
	/**
	 * 
	 * 2016年6月3日
	 * zhaoyi
	 * TODO
	 * @param value
	 * @return 返回键
	 */
	public Object getKey(Object value){
		for(int i=0;i<size;i++){
			if(keyvalue[i].getValue().equals(value)){
				return keyvalue[i].getKey();
				
			}
		}
		return null;
	}
	
	
	public void remove(int index){
		checkArray(index);
		//如果这样在原数组上操作就会出现迭代空指针异常
		System.arraycopy(keyvalue, index+1, keyvalue, index, size-index-1);
		keyvalue[size]=null;
		size--;
		
		//新数组迁移不会出现迭代空指针异常
/*		System.arraycopy(keyvalue, index+1, keyvalue, index, size-index-1);
		KeyValue[] newkv=new KeyValue[size-1];
		System.arraycopy(keyvalue, 0, newkv, 0, size-1);
		keyvalue=newkv;
		size--;*/


		
	}
	
	public static void main(String[] args) {
		MyMap mm=new MyMap();
		mm.add("赵义", new Wife("中岛美雪"));
		mm.add("赵义", new Wife("黄蓉"));
		mm.add("测试1", new Wife("张曼玉1"));
		mm.add("测试2", new Wife("张曼玉2"));
		mm.add("测试3", new Wife("张曼玉3"));
		mm.add("测试4", new Wife("张曼玉4"));
/*		System.out.println(mm.size());
		System.out.println(mm.get(0).getKey());
		System.out.println(mm.get(1).getKey());
		System.out.println(((Wife)mm.get(1).getValue()).getName());
		System.out.println(((Wife)mm.getValue("赵义")).getName());
		System.out.println((mm.getKey(new Wife("张曼玉"))));*/
		
		mm.remove(1);
		//使用这个不会跑出空指针
		System.out.println(mm.size());
		for(int i=0;i<mm.size();i++){
			System.out.println(mm.get(i).getKey());
		}
		//因为数组长度是固定的，所以你迭代是存在问题的
/*		for(KeyValue kv:mm.keyvalue){
			System.out.println(kv.getKey());
		}*/
		
/*		String[] s=new String[5];
		s[0]="0";
		s[1]="1";
		s[2]="2";
		s[3]="3";
		s[4]="4";
		
		System.arraycopy(s, 1, s, 1+1, 5-1-1);
		for(String d:s){
			System.out.println(d);
		}*/
		
	}
	
}
class KeyValue{

	private Object key;
	private Object value;
	/**
	 * @param key
	 * @param value
	 */
	public KeyValue(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Object getKey() {
		return key;
	}
	public Object getValue() {
		return value;
	}
	public void setKey(Object key) {
		this.key = key;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
}

class Wife{
	private String name;

	/**
	 * @param name
	 */
	public Wife(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wife other = (Wife) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
}