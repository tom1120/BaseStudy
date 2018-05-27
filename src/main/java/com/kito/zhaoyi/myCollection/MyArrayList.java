package com.kito.zhaoyi.myCollection;

/**
 * 2016年3月13日
 * @author zhaoyi
 * TODO 模拟实现jdk提供的ArrayList类
 */
public class MyArrayList {
    /**
     * The object is used for object storage.
     */
    private Object object[];

    /** 
     * The size is the number of objects used.
     */
    private int size;
	public int size(){
		return size;
	}
	public MyArrayList(){
		this(16);
	}
	public MyArrayList(int size){
		object=new Object[size];
	}
	public void add(Object obj){
		object[size]=obj;
		size++;
		if(size>=object.length){
			//扩容
			int newCapacity=object.length*2;
			Object[] newList=new Object[newCapacity];
			for(int i=0;i<object.length;i++){
				newList[i]=object[i];
			}
			object=newList;
		}
	}
	public Object get(int index){
		if(index<0||index>size-1){
			try {
				throw new Exception();//手动抛出一个异常
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return object[index];
	}
	
	
	
	
	/**
	 * 2016年3月13日
	 * zhaoyi
	 * TODO 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyArrayList list=new MyArrayList(2);
		list.add("aaa");
		list.add(new Human("赵义"));
		list.add("bbb");
		System.out.println(list.get(1));
		
//		System.out.println(list.get(4));
		
		System.out.println(list.size());
	}

}
