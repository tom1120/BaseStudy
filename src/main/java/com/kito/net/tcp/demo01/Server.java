package com.kito.net.tcp.demo01;/**
 * Created by hasee on 2017/8/6.
 */


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 聊天室群聊
 * @author zhaoyi
 * @createTime 2017-08-2017/8/6-8:18
 */
public class Server {


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8080);
        Socket socket=serverSocket.accept();//阻塞方法
        System.out.println("客户端建立连接");
        InputStream inputStream=socket.getInputStream();
        String receiveMsg="";

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        receiveMsg=bufferedReader.readLine();

        System.out.println("接收到消息："+receiveMsg);



    }

}
