package com.kito.zhaoyi.oop;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			//通过类加载器Class Loader加载Student，加载后方法区内就有Student代码
			Student s1=new Student();
			s1.name="赵义";
			s1.age=18;
			s1.study();
			s1.sayHello("大家");
			
			Computer c=new Computer();
			c.brand="lenenvo";
			c.cpuSpeed=100;
			
			s1.computer=c;
			System.out.println(s1.computer.brand);
			
			

	}

}
