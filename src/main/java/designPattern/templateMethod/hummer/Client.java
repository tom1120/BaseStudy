//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : BuyTicketClient.java
//  @ Date : 2015/12/7
//  @ Author : 
//
//



package designPattern.templateMethod.hummer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Client {
	public static void main(String[] args) throws IOException{
		System.out.println("-------H1启动------");
		System.out.println("H1");
		String type=(new BufferedReader(new InputStreamReader(System.in))).readLine();
		HummerH1Model h1=new HummerH1Model();
		if(type.equals("0")){
			h1.setAlarm(false);
		}
		h1.run();
		
		
		System.out.println("-------H2启动------");
		HummerH2Model h2=new HummerH2Model();
		h2.run();
		
		
	}
	
	
}
