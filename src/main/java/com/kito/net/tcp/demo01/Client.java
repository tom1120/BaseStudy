package com.kito.net.tcp.demo01;/**
 * Created by hasee on 2017/8/6.
 */

import java.io.*;
import java.net.Socket;

/**
 * @author zhaoyi
 * @createTime 2017-08-2017/8/6-8:18
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("localhost",8080);
        OutputStream client=socket.getOutputStream();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        System.out.print(" 输入: ");
        String msg=bufferedReader.readLine();

        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(client));

        System.out.println("msg = " + msg);
        bufferedWriter.write(msg);
        bufferedWriter.newLine();
        bufferedWriter.flush();

    }
}
