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

        System.out.println("s = " + s);
    }
}
