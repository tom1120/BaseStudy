//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Emperor.java
//  @ Date : 2015/12/2
//  @ Author : 
//
//

package designPattern.singleton;

public class Emperor {
	// generate the only one Emperor
	private static final Emperor emperor = new Emperor();

	private Emperor() {
		// overwrite default constructor method,set method modifier scope as
		// private
	}
	//provide method of outer to get the only Emperor instance  
	public static Emperor getInstances() {
		return emperor;
	}

	// 
	public static void say() {
		System.out.println("the Emperor saying...");
	}
}
