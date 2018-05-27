package com.kito.zhaoyi.io;

import java.io.File;

/**
 * 2016年4月12日
 * @author zhaoyi
 * TODO
 */
public class TestPrintFile {

	/**
	 * 2016年4月12日
	 * zhaoyi
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f=new File("D:/经典电视剧");
		printFile(f,0);
	}
	/**
	 * 
	 * 2016年4月12日
	 * zhaoyi
	 * TODO
	 * @param f 打印文件
	 * @param level 打印文件层级
	 */
	static void printFile(File f,int level){
		for(int i=0;i<level;i++){
			System.out.print("-");
		}
		System.out.println(f.getName());
		if(f.isDirectory()){
			File[] files=f.listFiles();
			for(File fl:files){
				printFile(fl,level+1);
			}
			
		}
	}

}
