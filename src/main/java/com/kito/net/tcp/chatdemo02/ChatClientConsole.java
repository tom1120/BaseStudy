package com.kito.net.tcp.chatdemo02;/**
 * Created by hasee on 2017/11/30.
 */

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zhaoyi
 * @createTime 2017-11-2017/11/30-21:47
 */
public class ChatClientConsole {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入您的名字：");
        String name = br.readLine();
        if(name==null){
            System.out.println("name不能为空！");
            return;
        }

        Socket socket = new Socket("localhost", 8888);//连接服务端
        new Thread(new ClientSend(socket,name)).start();//发送线程
        new Thread(new ClientReceive(socket)).start();//接收线程


    }
}
