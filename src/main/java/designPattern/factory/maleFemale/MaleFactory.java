//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : MaleFactory.java
//  @ Date : 2015/12/4
//  @ Author : 
//
//



package designPattern.factory.maleFemale;


public class MaleFactory implements designPattern.factory.maleFemale.IHumanFactory {
	public IHuman createWhiteHuman() {
		return new MaleWhiteHuman();
	}
	public IHuman createYellowHuman() {
		return new MaleYellowHuman();
	}
	public IHuman createBlackHuman() {
		return new MaleBlackHuman();
	}
}
