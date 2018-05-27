package com.kito.zhaoyi.oop.polymorphic;

/**
 * 2016年3月12日
 * @author zhaoyi
 * TODO
 */
public class Animal {
	public void volice(){
		System.out.println("普通动物叫声");
	}
}

class Cat extends Animal{
	/* (non-Javadoc)
	 * @see com.kito.zhaoyi.oop.polymorphic.Animal#volice()
	 */
	@Override
	public void volice() {
		// TODO Auto-generated method stub
		System.out.println("喵喵");
	}
	
}
class Dog extends Animal{
	/* (non-Javadoc)
	 * @see com.kito.zhaoyi.oop.polymorphic.Animal#volice()
	 */
	@Override
	public void volice() {
		// TODO Auto-generated method stub
		System.out.println("汪汪");
	}
}

class Pig extends Animal{
	/* (non-Javadoc)
	 * @see com.kito.zhaoyi.oop.polymorphic.Animal#volice()
	 */
	@Override
	public void volice() {
		// TODO Auto-generated method stub
		System.out.println("哼哼");
	}
}
class Tiger extends Animal{
	/* (non-Javadoc)
	 * @see com.kito.zhaoyi.oop.polymorphic.Animal#volice()
	 */
	@Override
	public void volice() {
		// TODO Auto-generated method stub
		System.out.println("唬唬");
	}
	public void bitPeople(){
		System.out.println("咬人");
	}
}