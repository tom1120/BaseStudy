package nettystudy.bio;/**
 * Created by hasee on 2018/5/13.
 */

import nettystudy.util.StreamCloseUtil;

import java.io.*;
import java.net.Socket;

/**
 * @author zhaoyi
 * @createTime 2018-05-2018/5/13-16:10
 */
public class TimeServerHanddlerThread implements Runnable {
    Socket socket = null;
    OutputStream os = null;
    InputStream is = null;

    public TimeServerHanddlerThread(Socket socket) {
        this.socket = socket;
        try {
            this.is = socket.getInputStream();
            this.os = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 接收客户端的消息
     */
    private void receiveClientAndReply() {
        InputStreamReader inputStreamReader = null;
        BufferedReader br = null;

        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bw = null;

        try {
            inputStreamReader = new InputStreamReader(this.is);
            br = new BufferedReader(inputStreamReader);
            outputStreamWriter = new OutputStreamWriter(this.os);
            bw = new BufferedWriter(outputStreamWriter);
            while (true) {
                String receiveString = br.readLine();
                if (receiveString == null)
                    break;
                System.out.println("接收到客户端的字符串为 = " + receiveString);

                bw.write("回复客户端消息");
                bw.newLine();
                bw.flush();
            }

        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("客户端断开连接"+socket.toString());
            StreamCloseUtil.closeAllStreams(is, os, socket);
        }

    }

    @Override
    public void run() {
        receiveClientAndReply();
    }
}
