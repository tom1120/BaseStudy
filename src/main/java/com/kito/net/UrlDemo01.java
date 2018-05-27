package com.kito.net;/**
 * Created by hasee on 2017/7/31.
 */

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author zhaoyi
 * @createTime 2017-07-2017/7/31-23:34
 */
public class UrlDemo01 {
    public static void main(String[] args) throws IOException {
        URL url=new URL("http://www.baidu.com:80/index.html#aa?uname=bjsxt");
        System.out.println("url.getProtocol() = " + url.getProtocol());
        System.out.println("url.getHost() = " + url.getHost());
        System.out.println("url.getPort() = " + url.getPort());
        System.out.println("url.getFile() = " + url.getFile());
        System.out.println("url.getQuery() = " + url.getQuery());
        System.out.println("url.getPath() = " + url.getPath());
        System.out.println("url.getContent() = " + url.getContent());
        //锚点存在就有值，否则为空
        System.out.println("url.getRef() = " + url.getRef());
        //主机加端口
        System.out.println("url.getAuthority() = " + url.getAuthority());
        System.out.println("url.getUserInfo() = " + url.getUserInfo());
        System.out.println("url.getDefaultPort() = " + url.getDefaultPort());
        System.out.println("url.toExternalForm() = " + url.toExternalForm());



        url=new URL("http://www.baidu.com/a/");
        url=new URL(url,"b.txt");
        System.out.println("url.getFile() = " + url.getFile());
        System.out.println("url.getPath() = " + url.getPath());
        System.out.println("url.toString() = " + url.toString());

    }
}
