package com.kito.zhaoyi.collection.list;

/**
 * 2016年5月22日
 * @author zhaoyi
 * TODO
 */
public class MyArrayList {
	
	private Object[] elementData;
	//数组元素之和
	private int size;
	
	public MyArrayList(){
		this(3);
	}
	public MyArrayList(int size){
		elementData=new Object[size];
		
	}
	public void addElement(Object o){
		extendSpace();
		elementData[size++]=o;
		
	}
	public int getSize(){
		return size;
	}
	
	private void extendSpace(){
		if(size+1>elementData.length){
			Object[] newArrayList=new Object[size*2+1];
			System.arraycopy(elementData, 0, newArrayList, 0, size);
			elementData=newArrayList;
		}
	}
	
	public void remove(int index) throws Exception{
		if(index<0||index>size+1)
			throw new Exception("错误的索引值："+index+"越界");
		
		
		while(index<size){
			if(index+1==size){
				elementData[index]=null;
			}
			elementData[index]=elementData[index+1];
			index++;
	
		}
		size--;
		
	}
	
	public boolean isEmpty(){
		return size>0?false:true;
	}
	
	public Object get(int index){
		if(index<0||index>size+1)
			try {
				throw new Exception("错误的索引值："+index+"越界");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return elementData[index];
	}
	

	/**
	 * 2016年5月22日
	 * zhaoyi
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyArrayList ml=new MyArrayList();
//		ml.addElement("123");
//		for(int i=0;i<ml.getSize();i++){
//			System.out.println(ml.elementData[i]);
//		}
//		System.out.println(ml.getSize());
//		System.out.println(ml.elementData.length);
		
		
		ml.addElement("123");
		ml.addElement("1234");
		ml.addElement("12345");		
		ml.addElement("123456");
		
		System.out.println(ml.getSize());
		System.out.println(ml.elementData.length);
		
		System.out.println("================");
		
		try {
			ml.remove(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Object s:ml.elementData){
			System.out.println(s);
		}

		System.out.println(ml.getSize());
		System.out.println(ml.elementData.length);
		
		System.out.println(ml.isEmpty());
		
		System.out.println(ml.get(1));
//		ArrayList
		
	}

}
