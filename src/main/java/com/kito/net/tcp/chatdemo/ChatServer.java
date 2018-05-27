package com.kito.net.tcp.chatdemo;/**
 * Created by hasee on 2017/8/23.
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;

/**
 * 服务端与聊天室
 *
 * @author zhaoyi
 * @createTime 2017-08-2017/8/23-22:26
 */
public class ChatServer {

    private static ServerSocket serverSocket;

    private static Socket socket;

    public ChatServer() {
    }

    public ChatServer(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }


    /**
     * 单个线程只能支持一个客户端通信
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ChatServer chatServer = new ChatServer(new ServerSocket(8888));
        socket = serverSocket.accept();//阻塞方法，一次只能服务一个客户端

        while (true) {
            InputStream inputStream = socket.getInputStream();


            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String receiveMsg = bufferedReader.readLine();//阻塞方法
            System.out.println("receiveClientMsg = " + receiveMsg);


            OutputStream outputStream = socket.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write("我已经收到！");
            bufferedWriter.newLine();
            bufferedWriter.flush();


        }


    }

}
