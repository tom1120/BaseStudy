package com.kito.zhaoyi.net.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 1)创建客户端，必须加上端口 
 * 
 * 2016年4月10日
 * 
 * @author zhaoyi TODO
 */
public class Client {

	/**
	 * 2016年4月10日 zhaoyi TODO
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// 面向连接的
			Socket client = new Socket("localhost", 8888);
/*			BufferedReader br = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			String echo=br.readLine();
			System.out.println(echo);*/
			
			//输入流
			DataInputStream dis=new DataInputStream(client.getInputStream());
			String echo=dis.readUTF();
			System.out.println(echo);
			//输出流
			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			dos.writeUTF("ping 127.0.0.1");
			dos.flush();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
