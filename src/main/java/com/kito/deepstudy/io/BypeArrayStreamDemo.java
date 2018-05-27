package com.kito.deepstudy.io;/**
 * Created by hasee on 2017/6/2.
 */

import java.io.*;

/**
 * 字节数组 节点流
 * 数组的长度有限，数据量不会很大
 * 文件的内容不用太大
 * 1、文件-程序-》字节数组  文件输入流 字节数组输出流
 * 2、字节数组-程序-》文件  字节数组输入流 文件输出流
 * @author zhaoyi
 * @createTime 2017-06-2017/6/2-21:07
 */
public class BypeArrayStreamDemo {
    /**
     * 读取文件数据到程序中，程序写到字节数组输出流
     * @param file
     */
    private static void readFileToProgram(File file) throws IOException {
        //数据源

        //输入流建立
        InputStream inputStream=new BufferedInputStream(
                new FileInputStream(file)
        );

        //输出流建立
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();


        //流每次搬运量
        byte[] bytes=new byte[1024];
        //实际搬运的长度
        int len=0;
        while (-1!=(len=inputStream.read(bytes))){
//            System.out.println("bytes[0] = " + bytes[1]);
            byteArrayOutputStream.write(bytes,0,len);
            byte[] dest=byteArrayOutputStream.toByteArray();
            System.out.println("new String(dest) = " + new String(dest,0,dest.length));
        }
        byteArrayOutputStream.flush();
        inputStream.close();
        byteArrayOutputStream.close();



    }

    /**
     * 把字符数组写入到文件中
     * @param srcBytes
     * @param destFile
     */
    private static void writeByteToFile(byte[] srcBytes,File destFile) throws IOException {
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(srcBytes);
        OutputStream outputStream=new BufferedOutputStream(new FileOutputStream(destFile));

        byte[] bytes=new byte[1024];
        int len=0;
        while (-1!=(len=byteArrayInputStream.read(bytes))){
            outputStream.write(bytes,0,len);
        }
        outputStream.flush();
        outputStream.close();
        byteArrayInputStream.close();

    }



    public static void main(String[] args) {
//        File f=new File("E:\\1.txt");
//        try {
//            readFileToProgram(f);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        File destFile=new File("E:\\destFile.txt");
        byte[] srcBytes=new String("的我所所asdasd").getBytes();
        try {
            writeByteToFile(srcBytes,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
