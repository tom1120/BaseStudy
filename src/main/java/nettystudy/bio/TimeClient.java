package nettystudy.bio;/**
 * Created by hasee on 2018/5/13.
 */

import nettystudy.util.StreamCloseUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author zhaoyi
 * @createTime 2018-05-2018/5/13-16:41
 */
public class TimeClient {
    public static void main(String[] args) {
        int port=8080;
        Socket socket=null;
        BufferedReader bufferedReader=null;
        BufferedWriter bufferedWriter=null;

        try {
            socket=new Socket("localhost",port);
            bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("客户端返回给服务端的消息："+System.currentTimeMillis());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            // 阻塞
            String receiveServerString=bufferedReader.readLine();
            System.out.println("收到服务端的消息 = " + receiveServerString);
        }catch (Exception e){
            e.printStackTrace();
            StreamCloseUtil.closeAllStreams(bufferedWriter,bufferedReader,socket);
        }


    }
}
