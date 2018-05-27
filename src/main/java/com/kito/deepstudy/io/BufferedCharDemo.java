package com.kito.deepstudy.io;/**
 * Created by hasee on 2017/5/30.
 */

import java.io.*;

/**
 * @author zhaoyi
 * @createTime 2017-05-2017/5/30-20:32
 */
public class BufferedCharDemo {

    public static void main(String[] args) {
        String srcPath="E:\\1.txt";
        String destPath="E:\\1-1.txt";
        try {
            fileReaderWriter(srcPath,destPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void fileReaderWriter(String srcPath,String destPath) throws IOException {
        File src=new File(srcPath);
        File dest=new File(destPath);
        Reader reader= new FileReader(src);
        Writer writer=new FileWriter(dest);
        char[] chars=new char[1024];
        int len=0;

        while (-1!=(len=reader.read(chars))){
            writer.write(chars,0,len);

        }
        writer.flush();
        writer.close();
        reader.close();

    }

    public void fileReaderWriterBuffered(String srcPath,String destPath) throws IOException {
        File src=new File(srcPath);
        File dest=new File(destPath);
        BufferedReader reader= new BufferedReader(new FileReader(src));
        BufferedWriter writer= new BufferedWriter(new FileWriter(dest));
        String s="";
        //使用新增功能不能发送多态
        while (null!=reader.readLine()){
            writer.write(s);
//            writer.append("\r\n");
            writer.newLine();
        }
        writer.flush();
        writer.close();
        reader.close();

    }





}
