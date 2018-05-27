package com.kito.deepstudy.io;/**
 * Created by hasee on 2017/5/30.
 */

import java.io.*;

/**
 * @author zhaoyi
 * @createTime 2017-05-2017/5/30-20:26
 */
public class BufferByteStreamDemo {
    public static void main(String[] args) {

    }

    public static void copyFile(File srcFile, File destFile) throws IOException {
        //缓冲流在字符流或者字节流之上
        InputStream inputStream=new BufferedInputStream(new FileInputStream(srcFile));
        OutputStream outputStream=new BufferedOutputStream(new FileOutputStream(destFile));
        //按1kb进行copy
        byte[] bytes=new byte[1024];
        //每次拷贝的长度
        int len=0;
        while (-1!=(len=inputStream.read(bytes))){
            //写出
            outputStream.write(bytes,0,len);

        }
        //强制流写出
        outputStream.flush();

        //关闭流
        outputStream.close();
        inputStream.close();

    }




}
