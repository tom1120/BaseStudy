package com.kito.net;/**
 * Created by hasee on 2017/7/31.
 */

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author zhaoyi
 * @createTime 2017-07-2017/7/31-23:25
 */
public class InetDemo01 {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress=InetAddress.getLocalHost();
        System.out.println("inetAddress.getAddress() = " + inetAddress.getAddress());
        System.out.println("inetAddress.getHostAddress() = " + inetAddress.getHostAddress());
        System.out.println("inetAddress.getHostName() = " + inetAddress.getHostName());
        System.out.println("inetAddress.getCanonicalHostName() = " + inetAddress.getCanonicalHostName());


        
    }




}
