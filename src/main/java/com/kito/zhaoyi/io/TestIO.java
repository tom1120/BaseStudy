package com.kito.zhaoyi.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 2016年4月15日
 * 
 * @author zhaoyi TODO
 */
public class TestIO {

	/**
	 * 2016年4月15日 zhaoyi TODO
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FileReader fr = new FileReader("D:/test.txt");
			char c = (char) fr.read();
			System.out.println(c);
			// unchecked exception
			int a = 0, b = 1;
			// int d=b/a;

			// hand throw exception
			if (a == 0)
				throw new MyException("错误！");

		} catch (FileNotFoundException e) {// checked exception
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}

	}

}

class MyException extends Exception {

	/**
	 * 
	 */
	public MyException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public MyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
