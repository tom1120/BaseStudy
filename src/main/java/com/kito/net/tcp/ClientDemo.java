package com.kito.net.tcp;/**
 * Created by hasee on 2017/8/3.
 */

import java.io.*;
import java.net.Socket;

/**
 * @author zhaoyi
 * @createTime 2017-08-2017/8/3-0:13
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("localhost",8888);
        //接受数据
//        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        String echo=bufferedReader.readLine();//阻塞式方法
//        System.out.println("echo = " + echo);
        DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
        ObjectInputStream objectInputStream=new ObjectInputStream(dataInputStream);
        String msg=objectInputStream.readUTF();
        System.out.println("msg = " + msg);



    }

}
