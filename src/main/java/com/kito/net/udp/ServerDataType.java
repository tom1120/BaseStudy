package com.kito.net.udp;/**
 * Created by hasee on 2017/8/1.
 */

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author zhaoyi
 * @createTime 2017-08-2017/8/1-0:30
 */
public class ServerDataType {
    public static void main(String[] args) throws IOException {
        //创建服务器+端口
        DatagramSocket datagramSocket=new DatagramSocket(8888);
        //准备接受容器
        byte[] contain=new byte[1024];
        //封装成包
        DatagramPacket datagramPacket=new DatagramPacket(contain,contain.length);
        //接受数据
        datagramSocket.receive(datagramPacket);
        //分析数据
        byte[] data=datagramPacket.getData();
        Double dd=convert(data);
        System.out.println("dd = " + dd);
        //释放
        datagramSocket.close();
    }

    public static Double convert(byte[] data) throws IOException {
        Double d=null;
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(data);
        DataInputStream dataInputStream=new DataInputStream(byteArrayInputStream);
        d=dataInputStream.readDouble();
        return d;

    }


}
