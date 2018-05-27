package com.kito.deepstudy.iter;

import java.util.Iterator;

/**
 * 2016年8月9日
 * @author zhaoyi
 * TODO 迭代器类似公交车售票员
 */
public class SimpleIterator {
	public int getSize() {
		return size;
	}


	private String[] elem={"a","b","c"};//公交车
	private int size=elem.length;//公交车容量
	//初始化指针为开始位置
	private int currentCursor=-1;//售票员还未清点乘客数量
	
	

	/**
	 * 
	 * 2016年8月9日
	 * zhaoyi
	 * TODO 判断是否存在下一个元素
	 * @return
	 */
	public boolean hasNext(){
		return currentCursor+1<size;
	}
	/**
	 * 
	 * 2016年8月9日
	 * zhaoyi
	 * TODO 如存在下一个元素指针就移动到下一位，【存在乘客，就返回当前乘客相关信息，并走到下面一位】
	 */
	public String next(){

		return elem[++currentCursor];
	}
	
	/**
	 * 
	 * 2016年8月9日
	 * zhaoyi
	 * TODO 删除当前元素后，指针指向下一个，【请未购票的乘客下车，并走向下一位】
	 * 对于具体公车的大小是固定的，不能变化。踢出没有买票的，整车人转移到一个新的公车中！
	 * currentCursor 0 1 2
	 * 				 a b c
	 * length		 1 2 3
	 */
	public void remove(){

		System.arraycopy(elem, currentCursor+1, elem, currentCursor, size-currentCursor-1);
		size--;
		currentCursor--;
	}
	

	public static void main(String[] args) {
		SimpleIterator simpleIterator=new SimpleIterator();
		
		while(simpleIterator.hasNext()){
			
			System.out.println(simpleIterator.next());
			simpleIterator.remove();
			
		}
		while(simpleIterator.hasNext()){
			
			System.out.println(simpleIterator.next());
			simpleIterator.remove();
			
		}
		while(simpleIterator.hasNext()){
			
			System.out.println(simpleIterator.next());
			simpleIterator.remove();
			
		}
		while(simpleIterator.hasNext()){
			
			System.out.println(simpleIterator.next());
			simpleIterator.remove();
			
		}
		System.out.println(simpleIterator.getSize());

		
	}
	
}
