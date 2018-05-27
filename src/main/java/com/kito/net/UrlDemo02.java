package com.kito.net;/**
 * Created by hasee on 2017/7/31.
 */

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author zhaoyi
 * @createTime 2017-07-2017/7/31-23:46
 */
public class UrlDemo02 {
    public static void main(String[] args) throws IOException {
        URL url=new URL("http://www.baidu.com");
//        URLConnection urlConnection=url.openConnection();
//        urlConnection.setReadTimeout(5000);
//        urlConnection.setConnectTimeout(10000);
        InputStream inputStream=url.openStream();

        //存在乱码
//        byte[] flush=new byte[1024];
//        int len=0;
//        while (-1!=(len=inputStream.read(flush))){
//            System.out.println("new String(flush,0,len) = " + new String(flush,0,len));
//        }
//        inputStream.close();
        BufferedReader br=new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
        BufferedWriter bw=new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(
                                new File("e:\\copytest\\index.html")
                        ),"utf-8"
                )
        );
        String msg=null;
        while ( null!=(msg=br.readLine())){
//            System.out.println("msg = " + msg);
            bw.append(msg);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
