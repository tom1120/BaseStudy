package com.kito.deepstudy.io;/**
 * Created by hasee on 2017/5/29.
 */

import java.io.*;

/**
 * @author zhaoyi
 * @createTime 2017-05-2017/5/29-11:45
 */
public class CopyFileDemo {

    public static void copyFile(String srcPath,String destPath){
        try {
            copyFile(new File(srcPath),new File(destPath));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void copyFile(File srcFile,File destFile) throws IOException {
        InputStream inputStream=new FileInputStream(srcFile);
        OutputStream outputStream=new FileOutputStream(destFile);
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


    public static void main(String[] args) {
        copyFile("E:\\test.jpg","E:\\testcopy.jpg");
    }



}
