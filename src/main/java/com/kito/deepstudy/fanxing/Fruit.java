package com.kito.deepstudy.fanxing;

/**
 * 2016年7月12日
 * @author zhaoyi
 * TODO
 */
public class Fruit<T,S> {
	T name;
	S value;

	public Fruit(T _name,S _value){
		this.name=_name;
		this.value=_value;
	}
	
	public void sayItSelf(){
		if(this.name instanceof String){
			System.out.println("T是字符型");
		}else{
			System.out.println("非字符型");
		}
		
		System.out.println(this.name+"|||||||"+this.value);
	}
	
}
