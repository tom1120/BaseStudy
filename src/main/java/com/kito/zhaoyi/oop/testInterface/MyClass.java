package com.kito.zhaoyi.oop.testInterface;

/**
 * 2016年3月13日
 * @author zhaoyi
 * TODO
 */
public class MyClass implements MyInterface {

	/* (non-Javadoc)
	 * @see com.kito.zhaoyi.oop.testInterface.MyInterface#test01()
	 */
	@Override
	public void test01() {
		// TODO Auto-generated method stub
		System.out.println(MyInterface.Max_GREAD);
		System.out.println(MyInterface.Max_SPEED);
	}

	/* (non-Javadoc)
	 * @see com.kito.zhaoyi.oop.testInterface.MyInterface#test02(int, int)
	 */
	@Override
	public int test02(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	/**
	 * 2016年3月13日
	 * zhaoyi
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
