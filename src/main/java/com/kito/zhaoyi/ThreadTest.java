package com.kito.zhaoyi;


class aThread extends Thread{
	int i;
	public aThread(int i){
		this.i = i;
	}
	
	public void run(){
		for(int j=0;j<=10;j++){
			System.out.println("�̳��߳���ʵ�ֵ��̣߳�"+i);
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
}
class bThread implements Runnable {
	long b;
	public bThread(long b){
		this.b = b;
	}
	public void run(){
		for(int i=0;i<=5;i++){
			System.out.println("Runnable�ӿ�ʵ�ֵ��̣߳�"+b);
		}
	}
	
}


public class ThreadTest {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		aThread a = new aThread(12);
		aThread b = new aThread(13);
		aThread c = new aThread(14);
		aThread d = new aThread(15);
		bThread x = new bThread(100);
		bThread y = new bThread(200);
		bThread z = new bThread(300);
		a.start();
		System.out.println("��������������1");
		b.start();
		System.out.println("��������������2");
		c.start();
		System.out.println("��������������3");
		d.start();
		try {
			new Thread(x).sleep(100);
			new Thread(y).sleep(100);
			new Thread(z).sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		new Thread(x).start();
		new Thread(y).start();
		new Thread(z).start();


	}

}
