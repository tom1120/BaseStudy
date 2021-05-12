package com.kito.deepstudy.io;/**
 * Created by hasee on 2017/5/30.
 */

import java.io.UnsupportedEncodingException;

/**
 * 乱码原因有两种
 * 1、编码与解码不对应
 * 2、字节缺位
 * @author zhaoyi
 * @createTime 2017-05-2017/5/30-21:21
 */
public class HunLuanCode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //编码
        byte[] bytes=new String("中国").getBytes("GBK");
        //解码
        String s=new String(bytes,"GBK");
        String s1=new String(bytes,"UTF-8");
        String s2=new String(bytes,"iso8859-1");

        System.out.println("s = " + s);
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }
}
