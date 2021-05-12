package com.kito.deepstudy.io;/**
 * Created by hasee on 2017/5/27.
 */

import java.io.CharArrayReader;
import java.io.UnsupportedEncodingException;

/**
 * @author zhaoyi
 * @createTime 2017-05-2017/5/27-22:26
 */
public class StringTest {

    private void testBypes(){
        String s= null;
        try {
//            s = new String("阿".getBytes(),"utf-8");//以utf-8编码一个汉字三个字节
            s = new String("阿".getBytes(),"gbk");//以gbk编码一个汉字6个字节
//            s = new String("阿".getBytes(),"iso8859-1");//以iso8859-1编码一个汉字6个字节
//            s = new String("阿".getBytes(),"utf-16");//以utf-16编码一个汉字6个字节

            System.out.println("s.getBytes() = " + s.getBytes());
            System.out.println("s.getBytes().length = " + s.getBytes().length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

    private void testChar(){
        char[] c=new char[1];
        c[0]='数';
        //default charset 为 UTF-8
        String s=new String(c);
        String englishchar=new String(new char[]{'a'});
        try {
            System.out.println("c[0] = " + c[0]);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("字符数长度"+s.getBytes().length);
        System.out.println("englishchar length= " + englishchar.getBytes().length);

    }

    public static void main(String[] args) {
        StringTest st=new StringTest();
        st.testBypes();
        st.testChar();


    }
}
