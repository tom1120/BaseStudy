package com.kito.deepstudy.io;/**
 * Created by hasee on 2017/1/2.
 */

import java.io.*;

/**
 * @author zhaoyi
 * @createTime 2017-01-2017/1/2-20:02
 */
public class FileStream {

    final String filePath="E:/2.txt";
    public void fileOutStream(){
        FileWriter fileWriter=null;
        try {
            fileWriter=new FileWriter(filePath);

            String s="abc我爱中国！";

            fileWriter.write(s);
            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileWriter!=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println(" fileWriter 已经关闭" );
            }

        }


    }

    public void fileInputStream(){
        FileReader fileReader=null;

        try {
            fileReader=new FileReader(filePath);
            int len=0;
            //两个字符一起读取
            char[] chars=new char[2];
            while (-1!=(len=fileReader.read(chars))){
                String s=new String(chars);
                System.out.println("s = " + s);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("fileReader 已经关闭" );
            }
        }


    }

    public static void main(String[] args) {
        FileStream fileStream=new FileStream();
        fileStream.fileOutStream();
        fileStream.fileInputStream();
    }

}
