package com.kito.zhaoyi.oop.callback;

/**
 * 2016年3月13日
 * @author zhaoyi
 * TODO
 */
public class PaintFrame {
	public static void drawFrame(MyFrame f) {
		System.out.println("启动线程");
		System.out.println("增加循环");
		System.out.println("查看消息栈");
		//画窗口
		f.paint();
		
		
		System.out.println("启动缓存，增加效率");
	}
	public static void main(String[] args) {
		MyFrame f=new GrameFrame();
		drawFrame(f);
	}
}

class GrameFrame extends MyFrame{

	@Override
	public void paint() {
		// TODO Auto-generated method stub
		System.out.println("画游戏窗口");
	}
	
}
