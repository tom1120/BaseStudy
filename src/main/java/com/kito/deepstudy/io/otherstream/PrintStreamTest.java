package com.kito.deepstudy.io.otherstream;/**
 * Created by hasee on 2017/7/17.
 */

import java.io.*;
import java.util.Scanner;

/**
 * @author zhaoyi
 * @createTime 2017-07-2017/7/17-23:08
 */
public class PrintStreamTest {
    /**
     * 打印字符到文件中
     * @throws FileNotFoundException
     */
    public static void writeFile() throws FileNotFoundException{
        OutputStream outputStream=new BufferedOutputStream(
                new FileOutputStream(
                        new File("E:/1234.txt")
                ));
        PrintStream printStream=new PrintStream(outputStream);
        printStream.append("dddddddddddddddddddddde");
//        printStream.format("我是%s",new String[]{"国家"});
        printStream.flush();
        printStream.close();
    }

    /**
     * 打印输出流到控制台
     */
    public static void printConsole(){
        System.out.println("test");
        PrintStream printStream=System.out;
        printStream.println(false);

    }

    /**
     * 读取数据
     * @throws FileNotFoundException
     */
    public static void printConsole1() throws FileNotFoundException {
        InputStream inputStream=System.in;
        inputStream=new BufferedInputStream(new FileInputStream(new File("E:/1234.txt")));
        Scanner scanner=new Scanner(inputStream);
//        System.out.println("请输入：");
        System.out.println(scanner.nextLine());
    }

    /**
     *重定向打印流
     * @throws FileNotFoundException
     */
    public static void redirectStream() throws FileNotFoundException {
        System.setOut(new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(
                                new File("E:/1234.txt")
                        )
                ),true
        )
        );
        System.out.println("写到文件了");

        //回控制台
        System.setOut(new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(FileDescriptor.out)
                ),true
        ));
        System.out.println("又回到控制台了");

    }

    /**
     * bufferReader操作
     * @throws IOException
     */
    public static void bufferRead() throws IOException {
        InputStream inputStream=System.in;
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        System.out.println("请输入：");
        String msg=bufferedReader.readLine();
        System.out.println(msg);
    }

    public static void main(String[] args)  {
        try {
            bufferRead();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
