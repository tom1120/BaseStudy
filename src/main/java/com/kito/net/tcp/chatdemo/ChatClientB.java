package com.kito.net.tcp.chatdemo;/**
 * Created by hasee on 2017/8/23.
 */

import java.io.*;
import java.net.Socket;

/**
 * @author zhaoyi
 * @createTime 2017-08-2017/8/23-22:33
 */
public class ChatClientB {
    private String name;
    public ChatClientB(){

    }

    public ChatClientB(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws IOException {
        ChatClientB chatClientB=new ChatClientB("B先生");

        Socket socket = new Socket("localhost", 8888);




        OutputStream outputStream = socket.getOutputStream();
        //从控制台输入
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String readString = bufferedReader.readLine();//阻塞方法
            bufferedWriter.write(chatClientB.getName()+":"+readString);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }

/*        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(inputStream));
        String receiveMsg = bufferedReader1.readLine();//阻塞方法
        System.out.println("receiveServerMsg = " + receiveMsg);*/




    }
}
