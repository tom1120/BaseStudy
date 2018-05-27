package com.kito.net;/**
 * Created by hasee on 2017/7/31.
 */

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * @author zhaoyi
 * @createTime 2017-07-2017/7/31-23:29
 */
public class InetSocketDemo01 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress=InetAddress.getByName("127.0.0.1");
        InetSocketAddress inetSocketAddress=new InetSocketAddress(inetAddress,9999);
        System.out.println("inetSocketAddress.getHostName() = " + inetSocketAddress.getHostName());
        System.out.println("inetSocketAddress.getAddress() = " + inetSocketAddress.getAddress());
        System.out.println("inetSocketAddress.getPort() = " + inetSocketAddress.getPort());
//        System.out.println("inetSocketAddress.getHostString() = " + inetSocketAddress.getHostString());
        System.out.println("inetSocketAddress.isUnresolved() = " + inetSocketAddress.isUnresolved());

    }
}
