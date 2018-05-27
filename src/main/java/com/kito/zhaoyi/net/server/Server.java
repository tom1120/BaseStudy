package com.kito.zhaoyi.net.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1）创建服务器指定端口 2016年4月10日
 * 
 * @author zhaoyi TODO
 */
public class Server {

	/**
	 * 2016年4月10日 zhaoyi TODO
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket server = new ServerSocket(8888);// 创建服务端
			Socket socket = server.accept();// 接收客户端请求，阻塞式
			// socket.setKeepAlive(true);
			System.out.println("一个客户端建立连接");
			// 发送数据
			String msg = "欢迎使用服务器！";
			// 输出流
			/*
			 * BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
			 * socket.getOutputStream())); bw.write(msg); bw.newLine();
			 * bw.flush();
			 */

			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(msg);
			dos.flush();
			//输入流
			DataInputStream dis=new DataInputStream(socket.getInputStream());
			String echo=dis.readUTF();
			System.out.println(echo);
			
			Runtime rt = Runtime.getRuntime();
			try {
				Process pc = rt.exec(echo);

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
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
