//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : BenzBuilder.java
//  @ Date : 2015/12/12
//  @ Author : 
//
//



package designPattern.builder.carBuilder;

import java.util.ArrayList;


public class BenzBuilder extends CarBuilder {
	private CarModel benzModel=new BenzModel();
	public void setSequence(ArrayList sequence) {
		this.benzModel.setSequence(sequence);
	}
	
	public CarModel getCarModel() {
		return this.benzModel;
		
	}
}
