package com.kito.net.tcp.chatdemo02;/**
 * Created by hasee on 2017/11/30.
 */

import com.kito.deepstudy.io.util.FileUtil;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * @author zhaoyi
 * @createTime 2017-11-2017/11/30-21:29
 */
public class ChatServerSupportSingleClient {


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);//提供服务

        //服务管道，
        Socket socket = serverSocket.accept();

        //接收客户端传递过来的消息
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String receiveClientMsg = null;

        //回复客户端消息
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        //一个服务管道只能服务一个客户端，当这个客户端断开后其他客户端无法使用
        while (true) {
                receiveClientMsg = dataInputStream.readUTF();//阻塞程序
                System.out.println("receiveClientMsg = " + receiveClientMsg);

                dataOutputStream.writeUTF("我收到了你的消息！");
                dataOutputStream.flush();

        }


    }


}
