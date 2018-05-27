package com.kito.zhaoyi.collection.list;

/**
 * 2016年5月31日
 * @author zhaoyi
 * TODO
 */
public class MyLinkedList {
	
	private Node first;
	private Node last;
	private int size;
	
	
	
	public void add(Object obj){
		Node newNode=new Node();
		if(first!=null){
			newNode.setHead(last);
			newNode.setObj(obj);
			newNode.setNext(null);
			last.setNext(newNode);
			last=newNode;
			
		}else{
			
			newNode.setHead(null);
			newNode.setObj(obj);
			newNode.setNext(null);
			first=newNode;
			last=newNode;
			
		}
		size++;
	}
	
	public int size(){
		return size;
	}
	
	private void rangeCheck(int index){
		if(index>=size||index<0){
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public Node get(Object obj){
		Node n=null;
		if(first!=null){
			
			if(first.getObj().equals(obj)){
				return first;
			}
			
			n=first;
			while(n.getNext()!=null){
				if(n.getObj().equals(obj)){
					return n;
				}
				n=(Node) n.getNext();
			}
		}
		return n;
	}
	
	
	public Node get(int index){
		rangeCheck(index);
		Node n=null;
		if(first!=null){
			
			if(index==0){
				n=first;
			}else{
				int j=1;
				n=first;
				while(j<=index){
					n=(Node) n.getNext();
					j++;
				}
			}

		}

		
		return n;
		
	}
	
	
	public void remove(int index){
		rangeCheck(index);
		Node removeNode=get(index);
		if(index==0){
			first=(Node) removeNode.getNext();
		}else if(index==size-1){
			last=(Node) removeNode.getHead();
		}else{
			
			Node previous=(Node) removeNode.getHead();
			Node nextNode=(Node) removeNode.getNext();
			previous.setNext(nextNode);
			nextNode.setHead(previous);
		}
		size--;
		
	}
	
	
	/**
	 * 2016年5月31日
	 * zhaoyi
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LinkedList
		
		MyLinkedList mll=new MyLinkedList();
		mll.add("aaa");
		mll.add("bbb");
		mll.add("ccc");
/*		System.out.println(mll.size());
		System.out.println(mll.get(0).getObj());
		
		mll.remove(2);
		System.out.println(mll.size());
		System.out.println(mll.get(1).getObj());*/
		
		System.out.println(mll.get("aaa").getObj());
	}

}
