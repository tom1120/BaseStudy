package com.kito.zhaoyi.oop.polymorphic;

/**
 * 2016年3月12日
 * @author zhaoyi
 * TODO
 */
public class Test {
	
/*	public static void testCatVolice(Cat c){
		c.volice();
	}
	public static void testCatVolice(Dog d){
		d.volice();
	}
	public static void testCatVolice(Pig p){
		p.volice();
	}*/
	
	
	public static void testAnimalVolice(Animal a){
		a.volice();
	}
	
	/**
	 * 2016年3月12日
	 * zhaoyi
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a=new Cat();
		testAnimalVolice(a);
		Animal b=new Dog();
		testAnimalVolice(b);
		Animal c=new Pig();
		testAnimalVolice(c);
		
		Animal t=new Tiger();
		Tiger t1=(Tiger)t;
		t1.bitPeople();
		
		if(t instanceof Tiger){
			((Tiger) t).bitPeople();
		}
	}

}
