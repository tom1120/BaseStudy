package com.kito.deepstudy.fanxing;

/**
 * 2016年7月12日
 * @author zhaoyi
 * TODO
 */
public class Client {

	/**
	 * 2016年7月12日
	 * zhaoyi
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Fruit<String,String> banana=new Banana<String,String>("香蕉","菲律宾");
		banana.sayItSelf();
		
		Fruit<String,String> fruit=new Apple<String,String,Integer>("苹果","中国",1);
		fruit.sayItSelf();
		
		Fruit oragine=new Oragine<String, String>("桔子", "超级");
		oragine.sayItSelf();
		
		
	}

}
