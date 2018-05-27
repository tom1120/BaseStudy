package com.kito.net.tcp;/**
 * Created by hasee on 2017/8/5.
 */

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhaoyi
 * @createTime 2017-08-2017/8/5-20:29
 */
public class MultiServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8888);
        while (true){
            Socket socket=serverSocket.accept();//阻塞式方法
            System.out.println("一个客户端建立连接");

            //发送数据
            String msg="发送的消息";
//            OutputStream o =socket.getOutputStream();
//            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(o));
//            bufferedWriter.write(msg);
//            bufferedWriter.newLine();
//            bufferedWriter.flush();

            DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(dataOutputStream);
            objectOutputStream.writeUTF(msg);
            objectOutputStream.flush();

        }
    }
}
