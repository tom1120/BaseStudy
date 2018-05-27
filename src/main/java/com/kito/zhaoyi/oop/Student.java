package com.kito.zhaoyi.oop;

public class Student {
	//静态的数据
	String name;
	int id;
	int age;
	String gender;
	int weight;
	Computer computer;
	//动态的行为
	public void study(){
		System.out.println(name+"在学习！");
	}
	public void sayHello(String sname){
		System.out.println(name+"对"+sname+"说:"+"你好！");
	}
	public static void main(String[] args) {
		//通过类加载器Class Loader加载Student，加载后方法区内就有Student代码
		Student s1=new Student();
		s1.name="赵义";
		s1.study();
		s1.sayHello("大家");
		Student s2=new Student();
		s2.name="老赵";
		s2.age=18;
		
	}
	
}
