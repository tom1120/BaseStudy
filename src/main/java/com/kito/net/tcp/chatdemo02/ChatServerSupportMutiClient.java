package com.kito.net.tcp.chatdemo02;/**
 * Created by hasee on 2017/12/1.
 */

import com.kito.deepstudy.io.util.FileUtil;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoyi
 * @createTime 2017-12-2017/12/1-22:39
 */
public class ChatServerSupportMutiClient {

    private List<MyChannel> all=new ArrayList<MyChannel>();

    public static void main(String[] args) throws IOException {

        new ChatServerSupportMutiClient().start();

    }


    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);//提供服务
        while (true) {
            //服务管道，
            Socket socket = serverSocket.accept();
            MyChannel myChannel=new MyChannel(socket);
            all.add(myChannel);//加入容器
            new Thread(myChannel).start();

        }

    }


    private class MyChannel implements Runnable{
        private boolean isRunning=true;
        private Socket socket;
        private DataInputStream dataInputStream;
        private DataOutputStream dataOutputStream;

        private String name;

        public MyChannel(Socket socket) {
            this.socket = socket;
            try {
                this.dataInputStream=new DataInputStream(socket.getInputStream());
                this.dataOutputStream=new DataOutputStream(socket.getOutputStream());
                this.name=dataInputStream.readUTF();
                sendMsg("欢迎您来到聊天室");//客户端发送给服务端，服务端返还发送给自己，欢迎用户来到服务器
                sendOthers(name+"进入聊天室",true);
            } catch (IOException e) {
                e.printStackTrace();
                isRunning=false;
                FileUtil.close(dataInputStream,dataOutputStream);
            }

        }

        /**
         * 接收到客户端的消息
         * @return
         */
        public String receiveClientMsg(){
            String msg="";
            try {
                msg=dataInputStream.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
                isRunning=false;
                FileUtil.close(dataInputStream,dataOutputStream);
            }
            return msg;
        }

        /**
         * 发送信息
         */
        public void sendMsg(String msg){
            if(null==msg&&msg.equals(""))
                return;

            try {
                dataOutputStream.writeUTF(msg);
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
                isRunning=false;
                FileUtil.close(dataInputStream,dataOutputStream);
                all.remove(this);
            }

        }


        /**
         * 发送给其他客户端
         */
        public void sendOthers(String msg,boolean isSysMsg){
            if(msg.contains("@")&&msg.indexOf(":")>-1){//私聊
                String privatename=msg.substring(1,msg.indexOf(":"));
                String content=msg.substring(msg.indexOf(":")+1);
                for (MyChannel other:all
                        ) {
                    if(other.name.equals(privatename)){
                        other.sendMsg(this.name+"悄悄对你说："+content);
                    }
                }
            }else{
                if(isSysMsg){
                    for (MyChannel other:all
                            ) {
                        if(other==this){
                            continue;
                        }

                        other.sendMsg("系统消息："+msg);


                    }
                }else {
                    for (MyChannel other:all
                            ) {
                        if(other==this){
                            continue;
                        }

                        other.sendMsg(this.name+"对所有人说："+msg);


                    }
                }

            }



        }







        @Override
        public void run() {
            while (isRunning){
                sendOthers(receiveClientMsg(),false);
            }
        }
    }


}
