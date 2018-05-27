package com.kito.deepstudy.io;/**
 * Created by hasee on 2017/5/30.
 */

import java.io.*;

/**
 * @author zhaoyi
 * @createTime 2017-05-2017/5/30-22:17
 */
public class ExchangeStream {

    private static void exchange() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                //转换流
                new InputStreamReader(
                        new FileInputStream(new File("E:\\1.txt")),"utf-8"
                )
        );

        BufferedWriter bufferedWriter=new BufferedWriter(
                //转换流
                new OutputStreamWriter(
                        new FileOutputStream(new File("E:\\1-2.txt")),"utf-8"
                )
        );

        String s="";
        while (null!=(s=bufferedReader.readLine())){
            bufferedWriter.write(s);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        bufferedReader.close();


    }


    public static void main(String[] args) {
        try {
            exchange();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
