package nettystudy.wio;/**
 * Created by hasee on 2018/5/13.
 */


import nettystudy.bio.TimeServerHanddlerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhaoyi
 * @createTime 2018-05-2018/5/13-16:04
 */
public class TimeServer {
    public static void main(String[] args) {
        int port =8080;
        if(args!=null&&args.length>0){
            port=Integer.valueOf(args[0]);
        }

        ServerSocket serverSocket=null;
        Socket socket=null;
        try {
            serverSocket=new ServerSocket(port);
            System.out.println("服务端启动在："+port);
            TimeServerHanddlerExecutePool timeServerHanddlerExecutePool=new TimeServerHanddlerExecutePool(50,10000);
            while (true){
                socket=serverSocket.accept();
                //一个socket开启一个线程处理客户端的
                timeServerHanddlerExecutePool.execute(new TimeServerHanddlerThread(socket));

            }
        }catch (IOException e){
            e.printStackTrace();

        } finally {
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
