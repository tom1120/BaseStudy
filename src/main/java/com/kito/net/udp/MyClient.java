package com.kito.net.udp;/**
 * Created by hasee on 2017/8/1.
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @author zhaoyi
 * @createTime 2017-08-2017/8/1-0:03
 */
public class MyClient {
    public static void main(String[] args) throws IOException {
        //创建客户端+端口
        DatagramSocket datagramSocket=new DatagramSocket(6666);
        //准备数据
        String msg="udp编程";
        byte[] data=msg.getBytes();
        DatagramPacket datagramPacket=new DatagramPacket(data,data.length,new InetSocketAddress("localhost",8888));
        //发送
        datagramSocket.send(datagramPacket);
        //释放
        datagramSocket.close();


    }
}
