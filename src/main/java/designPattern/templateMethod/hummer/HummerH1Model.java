//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : HummerH1Model.java
//  @ Date : 2015/12/7
//  @ Author : 
//
//



package designPattern.templateMethod.hummer;


public class HummerH1Model extends AbstractHummerModel {
	private boolean alarmFlag=true;
	protected void start() {
		System.out.println("H1启动");
	}
	
	protected void stop() {
		System.out.println("H1停止");
	}
	
	protected void alarm() {
		System.out.println("H1喇叭响");
	}
	
	protected void engineBoom() {
		System.out.println("H1引擎响起");
	}
	protected boolean isAlarm() {
		return this.alarmFlag;
	}
	
	protected void setAlarm(boolean isAlarm){
		this.alarmFlag=isAlarm;
	}
	
}
