package com.kito.zhaoyi.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;

/**
 * 2016年4月12日
 * 
 * @author zhaoyi TODO
 */
public class TestFile {

	/**
	 * 2016年4月12日 zhaoyi TODO
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String file = "D:" + File.separatorChar + "test.txt";
		System.out.println(file);
		File f1 = new File(file);
		f1.createNewFile();

		if (f1.isFile()) {
			System.out.println("这是一个文件");
		}
		if (f1.isDirectory()) {
			System.out.println("这是一个目录");
		}
		File f2=new File("D:/a/b/c");
		f2.mkdir();
		f2.mkdirs();
		

	}

}
