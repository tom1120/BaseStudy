package com.kito.zhaoyi.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2016年4月10日
 * 
 * @author zhaoyi TODO
 */
public class TestProcessCmd {

	/**
	 * 2016年4月10日 zhaoyi TODO
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime rt = Runtime.getRuntime();
		String command = "ping 127.0.0.1";
		try {
			Process pc = rt.exec(command);

			BufferedReader input = new BufferedReader(new InputStreamReader(
					pc.getInputStream(), "GBK"));

			String line = null;

			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}

			int exitVal;
			try {
				exitVal = pc.waitFor();
				System.out.println("Exited with error code " + exitVal);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
