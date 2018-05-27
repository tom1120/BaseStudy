package com.kito.net.tcp.chatdemo02;/**
 * Created by hasee on 2017/11/30.
 */

import com.kito.deepstudy.io.util.FileUtil;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zhaoyi
 * @createTime 2017-11-2017/11/30-22:49
 */
public class ClientSend implements Runnable {
    private DataOutputStream dataOutputStream;
    //扫描键盘输入
    private Scanner scanner;

    //控制线程的标识
    private boolean isRunning=true;

    private String name;

    public ClientSend() {
        scanner=new Scanner(System.in);
    }

    public ClientSend(Socket socket,String name) {

        this();
        try {
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
            this.name=name;
            sendMsg(name);
        } catch (IOException e) {
            e.printStackTrace();
            isRunning=false;
            FileUtil.close(dataOutputStream,scanner);
        }
    }

    public String getSendMsg(){
        String inputMsg=scanner.next();//阻塞程序
        return inputMsg;
    }

    public void sendMsg(String msg){

        if(msg!=null&&!msg.equals("")){
            try {
                dataOutputStream.writeUTF(msg);
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
                isRunning=false;
                FileUtil.close(dataOutputStream,scanner);
            }
        }


    }


    @Override
    public void run() {
        while(isRunning){
            sendMsg(getSendMsg());
        }
    }
}
