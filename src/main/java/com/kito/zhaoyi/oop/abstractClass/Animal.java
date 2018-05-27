package com.kito.zhaoyi.oop.abstractClass;

/**
 * 2016年3月13日
 * @author zhaoyi
 * TODO
 */
public abstract class Animal {
	protected abstract void run();
	protected void breath(){
		System.out.println("呼吸");
		run();
	}
	protected Animal(){
		System.out.println("创建一个动物");
	}
}

class Cat extends Animal{

	/* (non-Javadoc)
	 * @see com.kito.zhaoyi.oop.abstractClass.Animal#run()
	 */
	@Override
	protected void run() {
		// TODO Auto-generated method stub
		System.out.println("猫跑的很矫健");
		super.breath();
		
	}
	protected Cat(){
		super();
		System.out.println("创建猫");
	}
	
}