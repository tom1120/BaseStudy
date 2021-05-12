package com.kito.deepstudy.io;/**
 * Created by hasee on 2017/1/2.
 */

import java.io.*;
import java.util.Arrays;

/**
 * @author zhaoyi
 * @createTime 2017-01-2017/1/2-11:17
 */
public class StringStream {
    String filepath="E:/1.txt";

    /**
     * 输出流-》文件输出流
     */
    public void outStreamDemo(){

        File f=new File(filepath);

        String sourceString="asdasdasdas是的范德萨\r\n";
        OutputStream outputStream=null;
        try {
            outputStream=new FileOutputStream(f,true);

            outputStream.write(sourceString.getBytes());

            outputStream.flush();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("错误:找不到文件" + filepath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("错误:io异常" );
        }finally {
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("输出流已经关闭");
            }

        }
    }


    /**
     * 流从方向来分，分为输入流与输出流，以程序为中心来说的
     * 文件输入流
     * @param
     */
    public void inputStreamDemo(){
        //先关联目标，输入流的目标就是文件-》程序
        File file=new File(filepath);

        InputStream inputStream=null;
        String destString="";
        try {
            inputStream=new FileInputStream(file);
            byte[] b=new byte[1024];
            int len=0;
            while (-1!=(len=inputStream.read(b))){
                String s=new String(b,0,len);
                byte[] bt=s.getBytes("iso8859_1");
                // 以 iso8859_1 编码时出现乱码时 byte 值为 63
                if(bt[bt.length-1]==63){
                    byte[] b3=new byte[1];
                    //再读取一个字节
                    inputStream.read(b3);
                    byte temp=b3[0];


                    b3= Arrays.copyOf(b,b3.length+b.length);

                    b3[b3.length - 1] = temp;
                    //最后一个字符
                    byte[] b4=new byte[2];
                    System.arraycopy(b3,b3.length-2,b4,0,2);
                    String sss=new String(b4,0,b4.length);



                    s=new String(b3,0,b3.length);



                }

/*                for (Byte bb:bt
                     ) {
                    System.out.println("bb = " + bb);
                }*/

                destString+=s;
                System.out.println("s = " + s);
            }

            System.out.println("destString = " + destString);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("找不到文件");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public static void main(String[] args) {

        StringStream s=new StringStream();
        s.outStreamDemo();

        s.inputStreamDemo();


    }


}
