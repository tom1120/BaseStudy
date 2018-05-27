package com.kito.net.udp;/**
 * Created by hasee on 2017/8/1.
 */

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author zhaoyi
 * @createTime 2017-08-2017/8/1-0:30
 */
public class ClientDataType {
    public static void main(String[] args) throws IOException {
        //创建客户端+端口
        DatagramSocket datagramSocket=new DatagramSocket(6666);
        //准备数据
        Double d=89.12;
        byte[] data=convert(d);

        DatagramPacket datagramPacket=new DatagramPacket(data,data.length,new InetSocketAddress("localhost",8888));
        //发送
        datagramSocket.send(datagramPacket);
        //释放
        datagramSocket.close();
    }

    public static byte[] convert(Double d) throws IOException {
        byte[] data=null;
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        DataOutputStream dataOutputStream=new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeDouble(d);
        dataOutputStream.flush();
        data=byteArrayOutputStream.toByteArray();
        dataOutputStream.close();

        return data;
    }

}
