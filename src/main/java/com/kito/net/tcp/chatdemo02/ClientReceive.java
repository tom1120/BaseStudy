package com.kito.net.tcp.chatdemo02;/**
 * Created by hasee on 2017/11/30.
 */

import com.kito.deepstudy.io.util.FileUtil;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author zhaoyi
 * @createTime 2017-11-2017/11/30-23:29
 */
public class ClientReceive implements Runnable {
    private DataInputStream dataInputStream;

    private boolean isRunning=true;

    public ClientReceive() {
    }

    public ClientReceive(Socket socket) {
        try {
            this.dataInputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            isRunning=false;
            FileUtil.close(dataInputStream);
        }
    }


    public String getReceiveMsg(){
        String msg="";
        try {
             msg=dataInputStream.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }



    @Override
    public void run() {
        while(isRunning){
            System.out.println("getReceiveMsg() = " + getReceiveMsg());
        }
    }
}
