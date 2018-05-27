package com.kito.zhaoyi.oop.innerClass;

/**
 * 2016年3月13日
 * @author zhaoyi
 * TODO
 */
public class OuterClass {

	/**
	 * 2016年3月13日
	 * zhaoyi
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Face f=new Face();
		Face.Nose n=f.new Nose();
		n.breath();
		
		Face.Ear.listenStatic();
	}

}

class Face{
	int type;
	
	class Nose{
		String type;
		void breath(){
			System.out.println(Face.this.type);
			System.out.println("呼吸");
		}
	}
	static class Ear{
		static void listenStatic(){
			System.out.println("静静听");
		}
		void listen(){
			System.out.println("我在听");
		}
	}
}
