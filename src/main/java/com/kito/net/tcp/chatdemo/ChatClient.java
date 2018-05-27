package com.kito.net.tcp.chatdemo;/**
 * Created by hasee on 2017/8/23.
 */

import java.io.*;
import java.net.Socket;

/**
 * @author zhaoyi
 * @createTime 2017-08-2017/8/23-22:33
 */
public class ChatClient {

    private String name;

    public ChatClient() {
    }

    public ChatClient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws IOException {
        ChatClient chatClient=new ChatClient("A先生");
        Socket socket=new Socket("localhost",8888);
        OutputStream outputStream=socket.getOutputStream();
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(chatClient.getName()+":"+"我发言了，哈哈！");
        bufferedWriter.newLine();
        bufferedWriter.flush();
//        bufferedWriter.close();
//        outputStream.close();

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String receiveMsg = bufferedReader.readLine();
        System.out.println("receiveServerMsg = " + receiveMsg);
//        bufferedReader.close();
//        inputStream.close();

    }
}
